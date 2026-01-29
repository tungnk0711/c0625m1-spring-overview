package com.codegym.c06springgreeting.controller;

import com.codegym.c06springgreeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

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

    @GetMapping("/greeting")
    public String greeting(){
        String msg = greetingService.getMessage("Hello 03");
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
