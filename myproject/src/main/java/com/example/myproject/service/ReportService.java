package com.example.myproject.service;

import com.example.myproject.dto.ReportRequestDto;
import org.springframework.core.io.ByteArrayResource;

public interface ReportService {
    ByteArrayResource generateExcel(ReportRequestDto request);
    ByteArrayResource generatePdf(ReportRequestDto request);
}