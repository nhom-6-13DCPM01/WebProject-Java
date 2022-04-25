package com.Controller.Client.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.Database.entity.Product;
import com.Database.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Client/Product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/Shop")
    public String shop(@RequestParam(name="page",required = false,defaultValue = "0") Integer page,@RequestParam(name="size",required = false,defaultValue = "12") Integer size,Model model){
        Page<Product> list = productService.getListProduct(page, size);
        Page<Product> listDiscount = productService.getListDiscount();
        model.addAttribute("list",list);
        model.addAttribute("listDiscount",listDiscount);
        int totalPages = list.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "Client/shop";
    }

    @GetMapping("/Shopdetail")
    public String shopDetail(@RequestParam long id,Model model){
        Product product = productService.getProductbyId(id);
        model.addAttribute("product",product);
        return "Client/shopdetail";
    }
}
