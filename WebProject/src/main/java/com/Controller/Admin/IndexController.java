package com.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Admin")
public class IndexController {
    
    @GetMapping("/Index")
    public String Index(){
        
        return "Admin/index";
    }
    @GetMapping("/Categories")
    public String CategoriesShow(){
        return "Admin/categories";
    }
    

}
