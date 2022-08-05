package com.example.demo.service;

import com.example.demo.model.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product saveProduct(Product product);

    Optional<Product> getProduct(String name);

    List<Product> getProducts();

    void addCategoryToProduct(String categoryName, String productName);
}
