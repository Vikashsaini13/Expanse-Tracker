package com.example.ExpanseTracker.service;


import com.example.ExpanseTracker.model.Product;
import com.example.ExpanseTracker.model.User;
import com.example.ExpanseTracker.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    IProductRepo productRepo;

    public List<Product> getProductByDate(LocalDate date) {
        return productRepo.findByCreationDate(date);
    }

    public String addProduct(Product product) {
        productRepo.save(product);
        return "order successfully!!";
    }

    public String getExpenditureByMonth(User user, Integer year, Integer month) {
    List<Product> products= productRepo.findByUser(user);

    double expanse=0;
    if(products.size()!=0){
        for(Product product :products){
            if((product.getCreationDate().getMonthValue()==month) && (product.getCreationDate().getYear()==year)){
                expanse+=product.getPrice();
            }
        }

        return String.valueOf(expanse);
    }
    else{
        return "you never made an order...pls do order first!!";
    }

    }
}
