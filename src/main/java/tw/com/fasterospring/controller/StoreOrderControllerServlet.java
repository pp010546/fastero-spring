package tw.com.fasterospring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tw.com.fasterospring.common.LocalDateTimeAdapter;
import tw.com.fasterospring.service.intf.OrderMasterService;

@WebServlet("/orders/store/*")
public class StoreOrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Gson _gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
			.enableComplexMapKeySerialization().serializeNulls().setDateFormat(DateFormat.DATE_FIELD)
			.setPrettyPrinting().setVersion(1.0).create();
	@Autowired
	OrderMasterService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

// CROS
		setHeaders(response);

		System.out.println("SOCS: doGet...");

		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();

		if (pathInfo.split("/").length <= 2) {
			Integer storeId = Integer.parseInt(pathInfo.split("/")[1]);
			out.print(_gson.toJson(service.getByStoreId(storeId)));
			return;
		} else {
			Integer storeId = Integer.parseInt(pathInfo.split("/")[1]);
			Integer orderId = Integer.parseInt(pathInfo.split("/")[2]);

			out.print(_gson.toJson(service.getByStoreId(storeId, orderId)));
		}
	}

	private void setHeaders(HttpServletResponse response) {

		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}

}
