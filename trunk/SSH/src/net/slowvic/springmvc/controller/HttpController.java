package net.slowvic.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 */
@Controller
@RequestMapping("/ask")
public class HttpController {

	// @RequestBody注解只支持POST请求
	@RequestMapping("/handle01")
	@ResponseBody
	public String handle01(@RequestBody String employee) {
		System.out.println(employee);
		return "乱码";
	}

	@RequestMapping("/handle02")
	public String handle02(@RequestParam("a") String requestBody) {
		System.out.println(requestBody);
		return "logon";
	}

	// 数据转换绑定
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(sdf, false));
	}
	
	@RequestMapping("/date")
	public String getDate(@RequestParam("date") Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		return "logon";
	}
}
