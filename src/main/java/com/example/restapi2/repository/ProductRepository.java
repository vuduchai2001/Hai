package com.example.restapi2.repository;

import com.example.restapi2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends JpaRepository<Product, String> {

}
