package com.example.ExpanseTracker.repository;


import com.example.ExpanseTracker.model.Product;
import com.example.ExpanseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByCreationDate(LocalDate date);

    List<Product> findByUser(User user);
}
