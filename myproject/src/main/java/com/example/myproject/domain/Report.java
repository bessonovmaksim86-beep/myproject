package com.example.myproject.domain;

import com.example.myproject.domain.enums.ReportType;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String period;

    @Enumerated(EnumType.STRING)
    private ReportType type;

    private LocalDateTime generatedAt;

    @ManyToOne
    private User user;
}