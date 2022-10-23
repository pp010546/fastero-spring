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
import tw.com.fasterospring.service.intf.ReviewService;
import tw.com.fasterospring.vo.ReviewVO;

@WebServlet("/reviews/*")
public class ReviewControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson _gson = new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
			.enableComplexMapKeySerialization()
			.serializeNulls()
			.setDateFormat(DateFormat.DATE_FIELD)
			.setPrettyPrinting()
			.setVersion(1.0)
			.create();
	
	@Autowired
	private ReviewService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();
		
		Integer orderId = Integer.parseInt(pathInfo.split("/")[1]);
		out.print(_gson.toJson(service.getByOrderId(orderId)));
		return;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		
		ReviewVO vo = _gson.fromJson(request.getReader().readLine(), ReviewVO.class);
		
		PrintWriter out = response.getWriter();
		out.print(_gson.toJson(service.insert(vo)));
		
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		
		ReviewVO vo = _gson.fromJson(request.getReader().readLine(), ReviewVO.class);
		
		System.out.println(vo);
		
		PrintWriter out = response.getWriter();
		out.print(_gson.toJson(service.updateResponse(vo.getReviewStoreResponse(), vo.getOrderId())));
	}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
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
