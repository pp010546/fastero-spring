package tw.com.fasterospring.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import tw.com.fasterospring.service.intf.UserService;
import tw.com.fasterospring.vo.UserVO;


@WebServlet("/users")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new GsonBuilder()
		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
		    .enableComplexMapKeySerialization()
		    .serializeNulls()
		    .setPrettyPrinting()
		    .setVersion(1.0)
		    .create();
	
	@Autowired UserService service;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		PrintWriter out = response.getWriter();
		
		UserVO vo = _gson.fromJson(request.getReader().readLine(), UserVO.class);
		out.print(_gson.toJson(service.register(vo)));
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		PrintWriter out = response.getWriter();
		
		UserVO vo = _gson.fromJson(request.getReader().readLine(), UserVO.class);
		
		out.print(_gson.toJson(service.update(vo)));
	}
	
	/*
	 * CROS
	 */
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
