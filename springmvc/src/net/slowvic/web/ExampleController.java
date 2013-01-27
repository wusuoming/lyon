package net.slowvic.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.slowvic.domain.User;
import net.slowvic.middleware.task.AsyncTask;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExampleController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/example01")
    @ResponseBody
    public String example01(User user, Model model, HttpServletRequest request,
        @RequestParam(required = false) String flag) {
        if (StringUtils.isBlank(user.getUserName())) {
            user = (User) request.getAttribute("user");
        }
        // 使用了@ResponseBody，输出通过StringHttpMessageConverter直接输出到客户端
        return "Hello,World!";
    }

    @RequestMapping("/example02")
    public String example02(RedirectAttributes attrs) {
        User user = createUser();
        attrs.addFlashAttribute(user);
        attrs.addAttribute("flag", "123");
        return "redirect:/example01";
        // return "redirect:http://www.baidu.com"; // 绝对地址
    }

    @RequestMapping("/example03")
    public String example03(HttpServletRequest request) {
        User user = createUser();
        request.setAttribute("user", user);
        return "forward:/example01";
    }

    private User createUser() {
        User user = new User();
        user.setUserName("slowvic");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public User showUser() {
        User user = createUser();
        asyncTask.waitSoLong();
        return user;
    }
}
