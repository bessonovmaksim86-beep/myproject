package com.example.myproject.service;

import com.example.myproject.domain.Category;
import com.example.myproject.domain.Transaction;
import com.example.myproject.domain.enums.TransactionType;
import com.example.myproject.dto.TransactionDto;
import com.example.myproject.repository.CategoryRepository;
import com.example.myproject.repository.TransactionRepository;
import com.example.myproject.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    void createTransactionShouldSave() {
        TransactionRepository tr = Mockito.mock(TransactionRepository.class);
        CategoryRepository cr = Mockito.mock(CategoryRepository.class);

        Category category = new Category();
        category.setId(1L);
        Mockito.when(cr.findById(1L)).thenReturn(Optional.of(category));

        Transaction saved = new Transaction();
        saved.setId(10L);
        Mockito.when(tr.save(Mockito.any())).thenReturn(saved);

        TransactionServiceImpl service = new TransactionServiceImpl(tr, cr);

        TransactionDto dto = new TransactionDto();
        dto.setAmount(BigDecimal.valueOf(100));
        dto.setType(TransactionType.INCOME);
        dto.setCategoryId(1L);
        dto.setTransactionDate(LocalDate.now());

        Transaction result = service.create(dto);
        assertEquals(10L, result.getId());
    }
}