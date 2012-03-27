package net.slowvic.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logon")
public class LogOnController {

	@RequestMapping("/hello")
	public String hello(String userName) {
		return null;
	}
}
