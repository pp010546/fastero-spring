package tw.com.fasterospring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tw.com.fasterospring.common.LocalDateTimeAdapter;
import tw.com.fasterospring.dao.impl.StoreDAOIm;
import tw.com.fasterospring.dao.intf.StoreDAO;
import tw.com.fasterospring.service.intf.OrderMasterService;
import tw.com.fasterospring.vo.StoreVO;

@WebServlet("/orders/user/*")
public class UserOrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson _gson = new GsonBuilder()
					.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
					.enableComplexMapKeySerialization()
					.serializeNulls()
					.setDateFormat(DateFormat.DATE_FIELD)
					.setPrettyPrinting()
					.setVersion(1.0)
					.create();
	@Autowired OrderMasterService service;
	@Autowired StoreDAOIm storeDAO;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// CROS
		setHeaders(response);
		
		System.out.println("UOCS: doGet...");

		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();
		
		/* pathInfo = /orders/user/userId(/orderId)
		 * or
		 * pathInfo = /orders/user/userId/searchString
		 */
		if (pathInfo.split("/").length<=2) {
			Integer userId = Integer.parseInt(pathInfo.split("/")[1]);
			out.print(_gson.toJson(service.getByUserId(userId)));
			return;
			
		// 若傳入字串皆為數字
		}else if(pathInfo.split("/")[2].chars().allMatch( Character::isDigit)){
			Integer userId = Integer.parseInt(pathInfo.split("/")[1]);
			Integer orderId = Integer.parseInt(pathInfo.split("/")[2]);
			
			out.print(_gson.toJson(service.getByUserId(userId, orderId)));
			
		// 傳入字串為搜尋字串
		}else {
			System.out.println("name searching...");
			String storeName = pathInfo.split("/")[2];
			out.print(_gson.toJson(service.getByStoreName(storeName)));

		}
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
