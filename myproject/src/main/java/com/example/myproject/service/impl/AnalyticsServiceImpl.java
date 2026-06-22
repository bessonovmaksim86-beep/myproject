package com.example.myproject.service.impl;

import com.example.myproject.dto.MetricsDto;
import com.example.myproject.repository.jdbc.AnalyticsJdbcRepository;
import com.example.myproject.service.AnalyticsService;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {
    private final AnalyticsJdbcRepository repository;

    public AnalyticsServiceImpl(AnalyticsJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public MetricsDto loadMetrics() {
        return repository.loadMetrics();
    }
}