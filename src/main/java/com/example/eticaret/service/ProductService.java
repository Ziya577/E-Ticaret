package com.example.eticaret.service;

import com.example.eticaret.dto.ProductDto;
import com.example.eticaret.exceptions.ProductNotFoundException;
import com.example.eticaret.model.Product;
import com.example.eticaret.model.User;
import com.example.eticaret.repository.ProductRepository;
import com.example.eticaret.request.ProductRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    public ResponseEntity<List<Product>> getAllProduct() {

        return ResponseEntity.ok(productRepository.findAll());
    }

    public ProductDto addProduct(ProductRequest productRequest) {
        User user = userService.findById(productRequest.getId());

        Product product = new Product(
                productRequest.getPrice(),
                productRequest.getCategory(),
                productRequest.getColor(),
                productRequest.getAmount(),
                productRequest.getName(), user);

        Product savedProduct = productRepository.save(product);


        ProductDto productDto = modelMapper.map(savedProduct, ProductDto.class);

        return productDto;
    }


    public ProductDto updateProduct(Long id, ProductRequest productRequest) {


        Product foundedProduct = findByProductByProductId(id);

        Product products = new Product(
                foundedProduct.getId(),
                productRequest.getName(),
                productRequest.getCategory(),
                productRequest.getPrice(),
                productRequest.getColor(),
                productRequest.getAmount(),
                foundedProduct.getUser());

        Product updatedProduct = productRepository.save(products);

        ProductDto updatedProductDto = modelMapper.map(updatedProduct, ProductDto.class);

        return updatedProductDto;

    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product findByProductByProductId(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
    }
}

