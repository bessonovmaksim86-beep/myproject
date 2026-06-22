package com.example.myproject.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.myproject.dto.ReportRequestDto;
import org.springframework.core.io.ByteArrayResource;
import java.io.ByteArrayOutputStream;

public class PdfReportGenerator {
    public ByteArrayResource generate(ReportRequestDto request) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("MyProject Report"));
            document.add(new Paragraph("Type: " + request.getReportType()));
            document.add(new Paragraph("Period: " + request.getPeriod()));
            document.close();
            return new ByteArrayResource(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("PDF generation failed", e);
        }
    }
}
