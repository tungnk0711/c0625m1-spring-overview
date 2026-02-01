package com.codegym.c06springgreeting.controller;

import com.codegym.c06springgreeting.model.Employee;
import com.codegym.c06springgreeting.service.EmployeeService;
import com.codegym.c06springgreeting.service.GreetingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    // field-base
    @Autowired
    private EmployeeService employeeService;

    // field-base
    /*@Autowired
    private GreetingService greetingService;*/

    // setter-base
    /*private GreetingService greetingService;
    @Autowired
    public void setGreetingService(GreetingService greetingService){
        this.greetingService = greetingService;
    }*/

    // constructor-base
    private GreetingService greetingService;
    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/index")
    public String index(){
        String msg = greetingService.getMessage("Hello 03");
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/car?/s?o?/info")
    public String test1(HttpServletRequest request) {
        return "from test1(), request uri: " + request.getRequestURI();
    }

    @RequestMapping("/c*/s*d/info")
    public String test2(HttpServletRequest request) {
        return "from test2(), request uri: " + request.getRequestURI();
    }

    @RequestMapping("/card/**")
    public String test3(HttpServletRequest request) {
        return "from test3(), request uri: " + request.getRequestURI();
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public String findPet(@PathVariable("ownerId") Long ownerId, @PathVariable("petId") Long petId) {

        return "pet";
    }

    @GetMapping("/employee")
    public String handleEmployeeRequestByDept (@RequestParam("dept") String deptName,
                                               @RequestParam("name") String name,
                                               @RequestParam("age") Long age,
                                               Model map) {
        map.addAttribute("msg", "employees request by dept: " + deptName);
        return "my-page";
    }

    @ModelAttribute("employee")
    public Employee getEmployee (@PathVariable("id") long id) {
        Employee e = employeeService.findById(id);
        return e;
    }

    @RequestMapping("/employee/{id}")
    public String handleRequestById (@ModelAttribute("employee") Employee employee, Model model) {
        return "employee";
    }

}
