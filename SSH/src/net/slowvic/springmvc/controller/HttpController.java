package net.slowvic.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.slowvic.springmvc.model.Employee;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 */
@Controller
@SessionAttributes("emp")
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
	public String getDate(@RequestParam("date") Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		return "logon";
	}

	@RequestMapping("/toEmp")
	public ModelAndView rederectEmp() {
		Employee emp = new Employee();
		emp.setUserName("中文");
		// 必须显式将emp加入Model，才能自动填入Session
		ModelAndView mav = new ModelAndView("forward:/emp/add");
		mav.addObject("emp", emp);
		return mav;
	}
}
