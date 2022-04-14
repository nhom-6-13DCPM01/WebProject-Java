package com.Controller.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Authentication")
public class AuthenticationController {
    
    @GetMapping("/Login")
    public String Login(){

        return "Authentication/login";
    }
}
