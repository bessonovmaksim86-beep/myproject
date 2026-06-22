package com.example.myproject.domain;

import com.example.myproject.domain.enums.TransactionType;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    private Category category;

    private LocalDate transactionDate;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    private User user;
}