package com.example.tacocloud.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marat
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String hello() {

        return "home";
    }
    
    
}
