package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<Optional<Product>> getProduct(@RequestParam String name) {
        return ResponseEntity.ok().body(productService.getProduct(name));
    }

    @PostMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product body,
                                                 @RequestParam Long id){
        return ResponseEntity.ok().body(productService.updateProduct(body,id));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @GetMapping("/addcategory")
    public void addCategoryToProduct(@RequestParam String categoryName, String productName){
        productService.addCategoryToProduct(categoryName,productName);
    }

}