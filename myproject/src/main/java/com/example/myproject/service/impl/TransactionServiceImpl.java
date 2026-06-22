package com.example.myproject.service.impl;

import com.example.myproject.domain.Category;
import com.example.myproject.domain.Transaction;
import com.example.myproject.dto.TransactionDto;
import com.example.myproject.exception.ResourceNotFoundException;
import com.example.myproject.repository.CategoryRepository;
import com.example.myproject.repository.TransactionRepository;
import com.example.myproject.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Transaction create(TransactionDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Transaction t = new Transaction();
        t.setAmount(dto.getAmount());
        t.setType(dto.getType());
        t.setCategory(category);
        t.setTransactionDate(dto.getTransactionDate() != null ? dto.getTransactionDate() : LocalDate.now());
        t.setDescription(dto.getDescription());
        return transactionRepository.save(t);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}