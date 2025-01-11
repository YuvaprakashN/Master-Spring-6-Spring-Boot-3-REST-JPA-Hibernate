package com.eazybytes.eazyschool.eazyschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    @PostMapping("/login")
    public String loginPage(@RequestParam(required = false, value = "error") String error, @RequestParam(required = false, value = "logout") String logout, Model model) {

        String errMsg = null;
        if (error != null)
            errMsg = "Please enter valid credentials";
        if (logout != null)
            errMsg = "You have been successfully logged out";

        model.addAttribute("errorMessge", errMsg);
        return "login.html";
    }
}
