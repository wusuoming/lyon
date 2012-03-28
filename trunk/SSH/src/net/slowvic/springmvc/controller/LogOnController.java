package net.slowvic.springmvc.controller;

import java.io.UnsupportedEncodingException;

import net.slowvic.springmvc.model.Employee;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 不同的方法，路径不要相同(尤其注意参数化后)<br>
 * 数据转换只对请求参数有效，对其他如URL参数等无效<br>
 * 
 * @author xus
 * <p>
 */
@Controller
@RequestMapping("/logon")
public class LogOnController {

	private static final Log LOG = LogFactory.getLog(LogOnController.class);

	@RequestMapping(value = "/hello/{userId}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("userId") String userId,
			@RequestParam("prefix") String prefix,
			@RequestHeader("user-agent") String userAgent,
			@CookieValue("JSESSIONID") String sessionId)
			throws UnsupportedEncodingException {
		LOG.debug("JSESSIONID:" + sessionId);
		LOG.debug("User-Agent:" + userAgent);
		String userName = "无名小卒";
		if ("9527".equals(userId)) {
			userName = "华安";
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logon");
		mav.addObject("msg", prefix + "," + userName);
		return mav;
	}

	@RequestMapping(value = "/employee/{empId}")
	public ModelAndView employee(Employee employee) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee");
		mav.addObject("employee", employee);
		return mav;
	}
}
