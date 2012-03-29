package net.slowvic.springmvc.controller;

import net.slowvic.springmvc.model.Employee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
