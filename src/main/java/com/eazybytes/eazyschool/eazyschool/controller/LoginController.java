package com.eazybytes.eazyschool.eazyschool.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class LoginController {

  //  @GetMapping("/login")
   // @PostMapping("/login")
    @RequestMapping(value = "/login",method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(@RequestParam(required = false, value = "error") String error, @RequestParam(required = false, value = "logout") String logout, Model model) {

        String errMsg = null;
        if (error != null)
            errMsg = "Please enter valid credentials";
        if (logout != null)
            errMsg = "You have been successfully logged out";

        model.addAttribute("errorMessage", errMsg);
        return "login.html";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}
