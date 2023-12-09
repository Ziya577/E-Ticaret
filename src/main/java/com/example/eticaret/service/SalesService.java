package com.example.eticaret.service;

import com.example.eticaret.exceptions.InsufficientBalanceException;
import com.example.eticaret.exceptions.ProductNotAvailableException;
import com.example.eticaret.exceptions.ProductNotFoundException;
import com.example.eticaret.exceptions.UserNotFoundException;
import com.example.eticaret.model.Product;
import com.example.eticaret.model.User;
import com.example.eticaret.repository.ProductRepository;
import com.example.eticaret.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class SalesService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public SalesService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void buy(Long userId, Long productId, Integer count) {
        Optional<User> foundedUser = userRepository.findById(userId);
        Optional<Product> foundedProduct = productRepository.findById(productId);
        if (foundedUser.isPresent()) {
            User user = foundedUser.get();
            if (foundedProduct.isPresent()) {
                Product product = foundedProduct.get();
                if (user.getBalance().compareTo(product.getPrice()) >= 0) {

                    BigDecimal subtract = user.getBalance().subtract(product.getPrice());

                    user.setBalance(subtract);
                    userRepository.save(user);
                    if (product.getAmount() > 0) {
                        product.setAmount(product.getAmount() - 1);

                    } else throw new ProductNotAvailableException("Not available in warehouse");
                }else throw new InsufficientBalanceException("User's balance is insufficient");
            } else throw new ProductNotFoundException("Product not found");


        } else throw new UserNotFoundException("User not found");
    }
}