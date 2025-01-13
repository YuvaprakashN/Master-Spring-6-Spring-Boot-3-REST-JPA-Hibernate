package com.eazybytes.eazyschool.eazyschool.controller;

import com.eazybytes.eazyschool.eazyschool.model.Person;
import com.eazybytes.eazyschool.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession) {
        Person person=personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getEazyClass() && null != person.getEazyClass().getName()){
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        httpSession.setAttribute("loggedInPerson",person);
       // throw new RuntimeException("Bug");
        return "dashboard.html";
    }
}
