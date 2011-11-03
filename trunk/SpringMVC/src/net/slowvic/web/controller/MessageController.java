package net.slowvic.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slowvic.biz.MessageService;
import net.slowvic.model.bo.Message;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MessageController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Message> messages = getApplicationContext().getBean(
				MessageService.class).getMessages();
		ModelAndView modelAndView = new ModelAndView("messageView");
		modelAndView.addObject("messages", messages);
		return modelAndView;
	}
}
