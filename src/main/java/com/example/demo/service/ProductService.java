package com.example.demo.service;

import com.example.demo.data.ApiResponse;
import com.example.demo.data.ProductCard;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public ApiResponse<Long> saveProduct(Product product) {
        log.info("Guardando un nuevo producto {} en la base de datos", product.getName());
        Optional<Category> category = Optional.ofNullable(categoryRepository.findByName(product.getCategory().getName()));
        if (category.isEmpty()) return new ApiResponse<Long>(false, null, "Categoria no existe");
        Product productBD = new Product(null, product.getSku(), product.getName(), product.getPrice(),
                product.getWeight(), product.getDescription(), product.getImage(), category.get(),
                product.getCreate_date(), product.getStock());
        return new ApiResponse<Long>(true, productRepository.save(productBD).getId(), null);
    }

    @Override
    public ApiResponse<Product> getProduct(Long id) {
        log.info("Buscando producto {} en la base de datos", id);
        //Buscar el producto en la base de datos
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty())
            return new ApiResponse<Product>(false, null, "Producto no encontrado en la base de datos");
        return new ApiResponse<Product>(true, product.get(), null);
    }

    @Override
    public List<Product> getProducts() {
        log.info("Buscando todos los productos de la base de datos");
        return productRepository.findAll();
    }

    @Override
    public ApiResponse<List<ProductCard>> getProductCards() {
        log.info("Buscando todos los cards products de la base de datos");

        List<ProductCard> productCards = new ArrayList<ProductCard>();
        List<Product> products = getProducts();

        for (Product product : products) {
            productCards.add(
                    new ProductCard(product.getId(), product.getName(), product.getImage(), product.getPrice(),
                            product.getCategory().getName()));
        }


        return new ApiResponse<List<ProductCard>>(true,productCards,null);
    }

    @Override
    public void addCategoryToProduct(String categoryName, String productName) {
        Category category = categoryRepository.findByName(categoryName);
        Product product = productRepository.findByName(productName);
        product.setCategory(category);
    }

}
