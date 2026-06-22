package com.example.myproject.controller.api;

import com.example.myproject.domain.Transaction;
import com.example.myproject.dto.TransactionDto;
import com.example.myproject.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {
    private final TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> all() {
        return transactionService.findAll();
    }

    @PostMapping
    public Transaction create(@RequestBody TransactionDto dto) {
        return transactionService.create(dto);
    }
}
