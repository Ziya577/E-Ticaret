package com.example.eticaret.controller;

import com.example.eticaret.service.SalesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {
    private final SalesService salesService;

    public SaleController(SalesService salesService) {
        this.salesService = salesService;
    }
    @PostMapping("/buy")
    public void buy(@RequestParam Long userId,@RequestParam Long productId,Integer count){
        salesService.buy(userId,productId,count);

    }


}
