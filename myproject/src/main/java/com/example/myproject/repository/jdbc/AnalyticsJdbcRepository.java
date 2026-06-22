package com.example.myproject.repository.jdbc;

import com.example.myproject.dto.MetricsDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AnalyticsJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public AnalyticsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MetricsDto loadMetrics() {
        BigDecimal income = jdbcTemplate.queryForObject(
                "select coalesce(sum(amount),0) from transactions where type='INCOME'",
                BigDecimal.class);

        BigDecimal expense = jdbcTemplate.queryForObject(
                "select coalesce(sum(amount),0) from transactions where type='EXPENSE'",
                BigDecimal.class);

        Long count = jdbcTemplate.queryForObject(
                "select count(*) from transactions",
                Long.class);

        MetricsDto dto = new MetricsDto();
        dto.setTotalIncome(income);
        dto.setTotalExpense(expense);
        dto.setTransactionCount(count);
        dto.setBalance(income.subtract(expense));
        return dto;
    }
}
