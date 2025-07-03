package com.vilelatech.rh.adapters.inbound.web.controller.temp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoriesController {

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllCategories() {
        // Dados mock temporários
        List<Map<String, Object>> categories = List.of(
            Map.of("id", 1, "name", "Alimentação", "description", "Despesas com alimentação"),
            Map.of("id", 2, "name", "Transporte", "description", "Despesas com transporte"),
            Map.of("id", 3, "name", "Saúde", "description", "Despesas com saúde"),
            Map.of("id", 4, "name", "Educação", "description", "Despesas com educação"),
            Map.of("id", 5, "name", "Lazer", "description", "Despesas com lazer")
        );
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable Long id) {
        Map<String, Object> category = Map.of(
            "id", id,
            "name", "Categoria " + id,
            "description", "Descrição da categoria " + id
        );
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createCategory(@RequestBody Map<String, Object> request) {
        Map<String, Object> category = Map.of(
            "id", 999,
            "name", request.get("name"),
            "description", request.get("description")
        );
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCategory(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        Map<String, Object> category = Map.of(
            "id", id,
            "name", request.get("name"),
            "description", request.get("description")
        );
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
