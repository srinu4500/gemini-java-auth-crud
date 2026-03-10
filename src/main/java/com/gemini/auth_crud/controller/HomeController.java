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

    @GetMapping("/register")
    public String registerPage() {
        return "<html><body><h2>Registration Page</h2><p>Please use POST /api/users/register to register.</p><p>Already have an account? <a href='/login'>Login here</a></p></body></html>";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "<html><body><h2>Login Page</h2><form method='POST' action='/login'>Username: <input name='username'/><br/>Password: <input type='password' name='password'/><br/><button type='submit'>Login</button></form></body></html>";
    }
}
