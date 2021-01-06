package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("second")
public class ProductDAOSecondImplementation implements ProductDAO {
    @Override
    public int insertProduct(UUID id, Product product) {
        return 0;
    }

    @Override
    public List<Product> getProducts() {
        return List.of(new Product(UUID.randomUUID(), "Tomasz hajto"));
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteProduct(UUID id) {
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Product product) {
        return 0;
    }
}
