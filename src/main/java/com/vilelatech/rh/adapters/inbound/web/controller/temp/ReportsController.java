package com.vilelatech.rh.adapters.inbound.web.controller.temp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportsController {

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {
        Map<String, Object> summary = Map.of(
            "totalIncome", 15000.00,
            "totalExpense", 8500.00,
            "balance", 6500.00,
            "monthlyIncome", 5000.00,
            "monthlyExpense", 2800.00,
            "monthlyBalance", 2200.00
        );
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Map<String, Object>>> getCategoriesReport() {
        List<Map<String, Object>> categories = List.of(
            Map.of("name", "Alimentação", "amount", 1200.00, "percentage", 15.0),
            Map.of("name", "Transporte", "amount", 800.00, "percentage", 10.0),
            Map.of("name", "Saúde", "amount", 600.00, "percentage", 7.5),
            Map.of("name", "Educação", "amount", 1000.00, "percentage", 12.5),
            Map.of("name", "Lazer", "amount", 400.00, "percentage", 5.0)
        );
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/monthly")
    public ResponseEntity<List<Map<String, Object>>> getMonthlyReport() {
        List<Map<String, Object>> monthly = List.of(
            Map.of("month", "Janeiro", "income", 5000.00, "expense", 2800.00, "balance", 2200.00),
            Map.of("month", "Fevereiro", "income", 5000.00, "expense", 3200.00, "balance", 1800.00),
            Map.of("month", "Março", "income", 5000.00, "expense", 2500.00, "balance", 2500.00)
        );
        return ResponseEntity.ok(monthly);
    }
}
