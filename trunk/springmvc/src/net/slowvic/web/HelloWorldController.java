package net.slowvic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

    private static final Log log = LogFactory
        .getLog(HelloWorldController.class);

    public ModelAndView handleRequest(HttpServletRequest req,
        HttpServletResponse res) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        log.debug("message already setted.");
        mv.setViewName("hello");
        return mv;
    }

}
