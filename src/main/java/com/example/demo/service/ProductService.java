package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(@Qualifier("first") ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public int addProduct(Product product) {
        return productDAO.insertProduct(product);
    }

    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    public Optional<Product> getProductById(UUID id) {
        return productDAO.getProductById(id);
    }

    public int deleteProduct(UUID id) {
        return productDAO.deleteProduct(id);
    }

    public int updatePerson(UUID id, Product product) {
        return productDAO.updatePerson(id, product);
    }

}
