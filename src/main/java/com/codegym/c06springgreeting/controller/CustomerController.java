package com.codegym.c06springgreeting.controller;

import com.codegym.c06springgreeting.model.Customer;
import com.codegym.c06springgreeting.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Random;

import java.util.List;
@Controller
@RequestMapping("/customers")
public class CustomerController {
   @Autowired
   private CustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer){
        Random random = new Random();
        int rand = random.nextInt();
        customer.setId(rand);
        customerService.save(customer);
        return "/create";
    }
}
