package org.kafkaspring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<String> currencies(){
        return currencyService.getCurrencies();
    }

}
