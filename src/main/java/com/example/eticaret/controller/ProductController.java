package com.example.eticaret.controller;

import com.example.eticaret.dto.ProductDto;
import com.example.eticaret.model.Product;
import com.example.eticaret.request.ProductRequest;
import com.example.eticaret.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){

        return productService.getAllProduct();

    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductRequest productRequest ){
        return ResponseEntity.ok(productService.addProduct(productRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productService.updateProduct(id,productRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
       return ResponseEntity.ok().build();

    }









}
