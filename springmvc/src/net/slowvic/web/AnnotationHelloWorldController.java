package net.slowvic.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationHelloWorldController {

    private static final Log log = LogFactory
        .getLog(AnnotationHelloWorldController.class);

    @RequestMapping("/helloworld")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        log.debug("message already setted.");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/json", produces = "application/json")
    public ModelAndView showJson() {
        ModelAndView mv = new ModelAndView();
        Map<String, String> model = new HashMap<String, String>();
        model.put("msg", "HelloWorld");
        mv.addObject("message", model);
        mv.setViewName("hello");
        return mv;
    }
}
