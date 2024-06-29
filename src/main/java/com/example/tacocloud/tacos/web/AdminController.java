package com.example.tacocloud.tacos.web;

import com.example.tacocloud.tacos.OrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author marat
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrderAdminService adminService;

    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {

        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
    
    @GetMapping
    public String admin() {

        adminService.deleteAllOrders();
        return "admin";
    }
}
