package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("dao_impl")
public class ProductDAOImple implements ProductDAO {
    private List<Product> products = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product product) {
        products.add(new Product(id, product.getName()));
        return 1;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return products.stream().filter(product -> product.getID().equals(id)).findFirst();
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
