package net.slowvic.web;

import net.slowvic.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {

    @RequestMapping("/example01")
    @ResponseBody
    public String example01() {
        // 使用了@ResponseBody，输出通过StringHttpMessageConverter直接输出到客户端
        return "Hello,World!";
    }

    @RequestMapping("/example02")
    public String example02() {
        // return "forward:/example01";
        return "redirect:http://www.baidu.com"; // 绝对地址
    }

    @RequestMapping("/showUser")
    public ModelAndView showUser() {
        User user = new User();
        user.setUserName("slowvic");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showUser");
        mav.addObject(user);
        return mav;
    }
}
