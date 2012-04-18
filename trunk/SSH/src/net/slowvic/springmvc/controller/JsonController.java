package net.slowvic.springmvc.controller;

import net.slowvic.modal.domain.User;
import net.slowvic.springmvc.model.Employee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/json1")
    public void testJson01(@RequestBody String employee) {
        System.out.println(employee);
    }

    @RequestMapping("/json2")
    public ResponseEntity<Employee> testJson02(HttpEntity<Employee> emp) {
        Employee employee = emp.getBody();
        ResponseEntity<Employee> entity = new ResponseEntity<Employee>(
            employee, HttpStatus.OK);
        return entity;
    }

    @RequestMapping("/json3")
    @ResponseBody
    public Object testJson03() {
        User user = new User();
        user.setUserName("slowvic");
        user.setGender("男");
        user.setEmail("slowvic@gmail.com");
        return user;
    }
}
