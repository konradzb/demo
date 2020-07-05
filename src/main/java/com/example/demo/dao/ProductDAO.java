package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDAO {

    int insertProduct(UUID id, Product product);

    default int insertProduct(Product product) {
        UUID id = UUID.randomUUID();
        return insertProduct(id, product);
    }

    List<Product> getProducts();

    Optional<Product> getProductById(UUID id);

    int deleteProduct(UUID id);

    int updatePerson(UUID id, Product product);
}
