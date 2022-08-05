package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Product saveProduct(Product product) {
        log.info("Guardando un nuevo producto {} en la base de datos", product.getName());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(String name) {
        log.info("Buscando producto {} en la base de datos", name);
        return Optional.ofNullable(productRepository.findByName(name));
    }

    @Override
    public List<Product> getProducts() {
        log.info("Buscando todos los productos de la base de datos");
        return productRepository.findAll();
    }

    @Override
    public void addCategoryToProduct(String categoryName, String productName) {

        Category category = categoryRepository.findByName(categoryName);
        Product product = productRepository.findByName(productName);

        product.setCategory(category);
    }
}
