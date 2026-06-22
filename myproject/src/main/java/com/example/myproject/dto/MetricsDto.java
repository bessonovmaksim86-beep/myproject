package com.example.myproject.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class MetricsDto {
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;
    private Long transactionCount;
}