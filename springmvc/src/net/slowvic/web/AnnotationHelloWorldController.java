package net.slowvic.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import net.slowvic.domain.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationHelloWorldController {

    private static final Log log = LogFactory
        .getLog(AnnotationHelloWorldController.class);

    @RequestMapping("/helloworld")
    public ModelAndView hello(
        @Value("#{systemProperties['java.vm.version']}") String version) {
        // @Value 使用spEL
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

    @RequestMapping("/error/{id}")
    public String showError(@ModelAttribute User user,
        @RequestParam("flag") String[] flag,
        @PathVariable("id") String id,
        @RequestBody() MultiValueMap<String, String> bodyContent,
        WebRequest request, ModelMap model) {
        // User即为表单对象，SpringMVC没有Struts2中的根对象概念，因此，表单中user.userName是无法绑定的
        String other = request.getParameter("other");
        request.setAttribute("other", other, 0);
        BindingResult bindingResult = (BindingResult) model
            .get(BindingResult.MODEL_KEY_PREFIX + "string");
        bindingResult.addError(new ObjectError("userName", "null"));
        return "hello";
    }

    @RequestMapping("/reg")
    public String toReg() {
        return "reg";
    }

    @RequestMapping("/doReg")
    public String regist(@ModelAttribute("user") @Valid User user,
        Errors errors) {
        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println(error.getField() + ":"
                    + error.getDefaultMessage());
            }
        }
        return "reg";
    }

    // @InitBinder
    // 注册本Controller专用的PropertyEditor
    public void initBinderWithPropertyEditor(WebDataBinder binder) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        // 如果命令对象中有Date类型的属性，则使用该PropertyEditor
        binder.registerCustomEditor(Date.class, dateEditor);
    }
}
