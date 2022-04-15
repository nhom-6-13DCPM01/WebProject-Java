package com.Controller.Authentication;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Authentication")
public class AuthenticationController {
    
    @GetMapping("/Login")
    public String Login(){

        return "Authentication/login";
    }

    @GetMapping("/Register")
    public String Register(){

        return "Authentication/register";
    }

    @GetMapping("/error403")
	public String error403(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("User", authentication);
		return "Authentication/403";
	}

    @GetMapping("/RequestOTP")
    public String RequestOTP(){

        return "Authentication/requestotp";
    }
}
