package com.vilelatech.rh.adapters.inbound.web.controller.temp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entries")
@CrossOrigin(origins = "*")
public class EntriesController {

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllEntries() {
        // Dados mock temporários
        List<Map<String, Object>> entries = List.of(
            Map.of(
                "id", 1,
                "description", "Almoço",
                "amount", 25.50,
                "date", LocalDateTime.now().toString(),
                "category", Map.of("id", 1, "name", "Alimentação"),
                "type", "EXPENSE"
            ),
            Map.of(
                "id", 2,
                "description", "Salário",
                "amount", 5000.00,
                "date", LocalDateTime.now().toString(),
                "category", Map.of("id", 6, "name", "Renda"),
                "type", "INCOME"
            ),
            Map.of(
                "id", 3,
                "description", "Uber",
                "amount", 15.00,
                "date", LocalDateTime.now().toString(),
                "category", Map.of("id", 2, "name", "Transporte"),
                "type", "EXPENSE"
            )
        );
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEntryById(@PathVariable Long id) {
        Map<String, Object> entry = Map.of(
            "id", id,
            "description", "Lançamento " + id,
            "amount", 100.00,
            "date", LocalDateTime.now().toString(),
            "category", Map.of("id", 1, "name", "Categoria"),
            "type", "EXPENSE"
        );
        return ResponseEntity.ok(entry);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEntry(@RequestBody Map<String, Object> request) {
        Map<String, Object> entry = Map.of(
            "id", 999,
            "description", request.get("description"),
            "amount", request.get("amount"),
            "date", LocalDateTime.now().toString(),
            "category", request.get("category"),
            "type", request.get("type")
        );
        return ResponseEntity.ok(entry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEntry(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Map<String, Object> entry = Map.of(
            "id", id,
            "description", request.get("description"),
            "amount", request.get("amount"),
            "date", LocalDateTime.now().toString(),
            "category", request.get("category"),
            "type", request.get("type")
        );
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
