package com.example.restapi2.controller;

import com.example.restapi2.entity.Product;
import com.example.restapi2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
// localhost:8081/products/home
public class ProductController {
    // DI dependecy injection
    @Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping()// create
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}") // update
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        Product oldProduct = productRepository.findById(id).get();
        oldProduct.setPrice(product.getPrice());
        oldProduct.setName(product.getName());
        return productRepository.save(oldProduct);
    }

    @GetMapping() // get
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @DeleteMapping("/{id}") // xóa
    public void deleteProduct(@PathVariable("id") String id){
        productRepository.deleteById(id);
    }
}
