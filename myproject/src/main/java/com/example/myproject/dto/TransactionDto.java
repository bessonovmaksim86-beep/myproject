package com.example.myproject.dto;

import com.example.myproject.domain.enums.TransactionType;
import lombok.Data;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionDto {
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    @NotNull
    private TransactionType type;

    @NotNull
    private Long categoryId;

    @NotNull
    private LocalDate transactionDate;

    @Size(max = 1000)
    private String description;
}