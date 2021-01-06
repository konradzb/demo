package com.example.demo.dao;

import com.example.demo.model.Product;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("first")
public class ProductDAOImple implements ProductDAO {
    private List<Product> products = Lists.newArrayList(new Product(UUID.randomUUID(), "Test1"),
            new Product(UUID.randomUUID(), "Test2"),
            new Product(UUID.randomUUID(), "Test3"),
            new Product(UUID.randomUUID(), "Test4"),
            new Product(UUID.randomUUID(), "Test5"));

    @Override
    public int insertProduct(UUID id, Product product) {
        products.add(new Product(UUID.randomUUID(), product.getName()));
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
        Optional<Product> productMaybe = getProductById(id);
        if(productMaybe.isEmpty())
            return 0;
        products.remove(productMaybe.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Product updateProduct) {
        return getProductById(id).map(person -> {
            int indexOfUpdateProduct = products.indexOf(person);
            if(indexOfUpdateProduct >= 0) {
                products.set(indexOfUpdateProduct, new Product(id, updateProduct.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
