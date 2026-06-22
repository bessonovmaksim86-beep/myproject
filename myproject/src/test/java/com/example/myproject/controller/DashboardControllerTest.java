package com.example.myproject.controller;

import com.example.myproject.dto.MetricsDto;
import com.example.myproject.service.AnalyticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DashboardController.class)
class DashboardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AnalyticsService analyticsService;

    @Test
    void dashboardShouldReturnOk() throws Exception {
        MetricsDto dto = new MetricsDto();
        dto.setTotalIncome(BigDecimal.TEN);
        dto.setTotalExpense(BigDecimal.ONE);
        dto.setBalance(BigDecimal.valueOf(9));
        dto.setTransactionCount(2L);

        when(analyticsService.loadMetrics()).thenReturn(dto);

        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk());
    }
}