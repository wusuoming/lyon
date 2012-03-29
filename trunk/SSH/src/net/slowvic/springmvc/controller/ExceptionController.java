package net.slowvic.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping("/exception")
	public void exceptionTest() throws Exception {
		throw new Exception("I don't know");
	}

	// 处理异常
	@ExceptionHandler
	public String handleException(Exception e, HttpServletRequest request) {
		System.out.println(e.getMessage());
		request.setAttribute("e", e);
		return "errors/exception";
	}
}
