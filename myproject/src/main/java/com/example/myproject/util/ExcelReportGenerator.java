package com.example.myproject.util;

import com.example.myproject.dto.ReportRequestDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import java.io.ByteArrayOutputStream;

public class ExcelReportGenerator {
    public ByteArrayResource generate(ReportRequestDto request) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Report");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("MyProject Report");
            row.createCell(1).setCellValue(request.getReportType().toString());
            row.createCell(2).setCellValue(request.getPeriod());
            workbook.write(out);
            return new ByteArrayResource(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Excel generation failed", e);
        }
    }
}
