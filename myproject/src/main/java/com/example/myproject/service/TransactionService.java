package com.example.myproject.service;

import com.example.myproject.domain.Transaction;
import com.example.myproject.dto.TransactionDto;
import java.util.List;

public interface TransactionService {
    Transaction create(TransactionDto dto);
    List<Transaction> findAll();
}