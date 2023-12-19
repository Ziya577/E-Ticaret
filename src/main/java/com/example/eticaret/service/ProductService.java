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
import java.util.Optional;

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

       Product foundedProduct = findProductByProductId(id);

        foundedProduct.setName(productRequest.getName());
        foundedProduct.setAmount(productRequest.getAmount());
        foundedProduct.setColor(productRequest.getColor());
        foundedProduct.setPrice(productRequest.getPrice());
        foundedProduct.setAmount(productRequest.getAmount());
        foundedProduct.setCategory(productRequest.getCategory());

        Product save = productRepository.save(foundedProduct);

        ProductDto map = modelMapper.map(save, ProductDto.class);

        return map;

    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product findProductByProductId(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
    }
}

