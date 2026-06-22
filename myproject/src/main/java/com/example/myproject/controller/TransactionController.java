package com.example.myproject.controller;

import com.example.myproject.domain.Transaction;
import com.example.myproject.dto.TransactionDto;
import com.example.myproject.repository.CategoryRepository;
import com.example.myproject.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionController {
    private final TransactionService transactionService;
    private final CategoryRepository categoryRepository;

    public TransactionController(TransactionService transactionService, CategoryRepository categoryRepository) {
        this.transactionService = transactionService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/transactions")
    public String list(Model model) {
        model.addAttribute("transactions", transactionService.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("transactionDto", new TransactionDto());
        return "transactions";
    }

    @PostMapping("/transactions")
    public String create(@ModelAttribute("transactionDto") TransactionDto dto) {
        transactionService.create(dto);
        return "redirect:/transactions";
    }
}