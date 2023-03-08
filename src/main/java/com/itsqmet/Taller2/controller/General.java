package com.itsqmet.Taller2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class General {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
