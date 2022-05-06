package com.example.Hafen_DB.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class IndexController {
    
    @GetMapping("/")
    public String index(@RequestParam(name="activePage", required = false, defaultValue = "home") String activePage, Model model) {
        model.addAttribute("activePage", activePage);
        return "index.html";
    }
}
