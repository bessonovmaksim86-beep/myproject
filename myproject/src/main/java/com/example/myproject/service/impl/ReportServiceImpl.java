package com.example.myproject.service.impl;

import com.example.myproject.dto.ReportRequestDto;
import com.example.myproject.service.ReportService;
import com.example.myproject.util.ExcelReportGenerator;
import com.example.myproject.util.PdfReportGenerator;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    private final ExcelReportGenerator excelGenerator = new ExcelReportGenerator();
    private final PdfReportGenerator pdfGenerator = new PdfReportGenerator();

    @Override
    public ByteArrayResource generateExcel(ReportRequestDto request) {
        return excelGenerator.generate(request);
    }

    @Override
    public ByteArrayResource generatePdf(ReportRequestDto request) {
        return pdfGenerator.generate(request);
    }
}