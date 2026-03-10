package com.gemini.auth_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping("/")
    public String welcome(Principal principal) {
        if (principal != null) {
            return "Welcome " + principal.getName();
        }
        return "Welcome Srinu";
    }
}
