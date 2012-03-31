package net.slowvic.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import net.slowvic.springmvc.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 千万要注意很多东西都是跟HTTP的请求方式相关联的，用于get方式的可能不适合于post
 */
@Controller
@SessionAttributes("emp")
@RequestMapping("/emp")
public class EmployeeController {

	// 直接通过url访问
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getEmployeeFromURL(
			@RequestParam("src") @Valid @ModelAttribute Employee emp) {
		System.out.println(emp.getUserName());
		return "logon";
	}

	// 提交新增数据
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String postEmployeeFromPageForm(@Valid @ModelAttribute Employee emp,
			Errors allErrors) {
		List<FieldError> errors = allErrors.getFieldErrors();
		if (errors != null && !errors.isEmpty()) {
			for (FieldError error : errors) {
				System.out
						.println(error.getField() + error.getDefaultMessage());
			}
			return "employee";
		} else {
			System.out.println(emp);
			return "logon";
		}
	}

	// 访问新增页面
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelMap map, SessionStatus sessionStatus) {
		ModelAndView mav = new ModelAndView("employee");
		Employee emp = (Employee) map.get("emp");
		if (emp == null) {
			emp = new Employee();
		}
		sessionStatus.setComplete();
		mav.addObject("employee", emp);
		return mav;
	}
}
