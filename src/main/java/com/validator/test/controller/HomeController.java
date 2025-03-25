package com.validator.test.controller;

import com.validator.test.dto.*;
import com.validator.test.service.*;
import org.springframework.stereotype.Controller; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Objects;

@RequestMapping("/mail")
@Controller
public class HomeController {


     @Autowired
      private EmailValidatorService service;


      @GetMapping("/")
       public String home(Model model) {
             model.addAttribute("mailValidator", new TestInput());
             model.addAttribute("show",false);
             return "index";
       }
      @PostMapping("/test")
      public String validateEmail(Model model, @ModelAttribute TestInput mailValidator) {
            Validator validator = service.readContent(mailValidator.getEmail());
            model.addAttribute("show", true);
            if(!Objects.isNull(validator)) {
               if(validator.isValid())
                model.addAttribute("valid", "Email is Valid");
               else
                 model.addAttribute("valid", "Email is Invalid");

               if(validator.isDisposable())
                   model.addAttribute("disposable", "Disposable email is detected");
               else
                   model.addAttribute("disposable", "Email is not disposable");

               if(validator.isBlock())
                   model.addAttribute("disposable", "Email is blacklisted");
               else
                   model.addAttribute("block", "Email is not blacklisted");

               model.addAttribute("finalResponse", "Your Email "+validator.getText());
            }
            model.addAttribute("mailValidator" , mailValidator);
           return "index";
      }

}