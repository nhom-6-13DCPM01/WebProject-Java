package com.Database.service;

import com.Database.entity.Product;

import org.springframework.data.domain.Page;


public interface ProductService {

    Page<Product> getListProduct(Integer page,Integer size);

    Page<Product> getListDiscount();

    Product getProductbyId(long id);
}
