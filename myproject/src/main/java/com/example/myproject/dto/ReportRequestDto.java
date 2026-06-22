package com.example.myproject.dto;

import com.example.myproject.domain.enums.ReportType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReportRequestDto {
    @NotNull
    private ReportType reportType;

    @NotBlank
    private String period;
}