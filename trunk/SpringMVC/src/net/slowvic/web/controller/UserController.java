package net.slowvic.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slowvic.model.bo.User;
import net.slowvic.util.WebUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user", method = { RequestMethod.GET,
		RequestMethod.POST })
public class UserController {

	@RequestMapping(params = "p=display")
	public ModelAndView displayUser(HttpServletRequest request,
			HttpServletResponse response, User user)
			throws ServletRequestBindingException, IOException {
		WebUtils.writeResponse(response, "html", user.getUserName());
		return null;
	}

	@RequestMapping(params = "p=reg")
	public ModelAndView forwardRegPage() {
		return new ModelAndView("reg");
	}
}
