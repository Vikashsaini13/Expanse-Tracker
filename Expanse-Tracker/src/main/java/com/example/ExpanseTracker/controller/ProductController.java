package com.example.ExpanseTracker.controller;



import com.example.ExpanseTracker.model.Product;
import com.example.ExpanseTracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    //add product
    @PostMapping("product")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    //fetch product for a particular date
    @GetMapping("product/date/{date}")
    public List<Product> getProductByDate(@PathVariable LocalDate date){
        return productService.getProductByDate(date);
    }
}
