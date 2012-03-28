package net.slowvic.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 可以使用Servlet API，如使用Response直接渲染，返回void
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/show")
    public void show(WebRequest request, HttpServletResponse response)
        throws IOException {
        String info = request.getParameter("info");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(info);
        pw.flush();
        pw.close();
    }

    /**
     * 可以将Principal和Locale作为形参
     * 
     * @param principal
     * @param locale
     * @param response
     * @throws IOException
     */
    @RequestMapping("/params")
    public void param(Principal principal, Locale locale,
        HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        if (principal != null)
            pw.write(principal.getName() + "\n");
        pw.write(locale.getCountry());
        pw.flush();
        pw.close();
    }
}
