package com.eazybytes.eazyschool.eazyschool.controller;

import com.eazybytes.eazyschool.eazyschool.model.Contact;
import com.eazybytes.eazyschool.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {

        if (errors.hasErrors()) {
            log.error("Form validation failed: " + errors.toString());
            return new ModelAndView("contact.html");
        }

        contactService.saveMessageDetails(contact);
        contactService.setCounter(1);
        log.info("Number of times the Contact form is submitted : "+contactService.getCounter());
        return new ModelAndView("redirect:/contact");
    }

}
