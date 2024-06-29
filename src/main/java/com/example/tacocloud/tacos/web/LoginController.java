package com.example.tacocloud.tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marat
 */
//@Controller
//@RequestMapping("login")
public class LoginController {

//    @GetMapping
    public String page() {
        
        return "login";
    }

}
