package com.example.demo.api;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@Valid @NotNull @RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable("id") UUID id) {
        productService.deleteProduct(id);
    }
    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable("id") UUID id, @NotNull @Valid @RequestBody Product product) {
        productService.updatePerson(id, product);
    }



}
