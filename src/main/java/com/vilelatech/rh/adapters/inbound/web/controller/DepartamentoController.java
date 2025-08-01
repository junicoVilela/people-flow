package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.departamento.DepartamentoFilter;
import com.vilelatech.rh.application.dto.departamento.DepartamentoRequest;
import com.vilelatech.rh.application.dto.departamento.DepartamentoResponse;
import com.vilelatech.rh.application.dto.departamento.DepartamentoUpdateRequest;
import com.vilelatech.rh.application.usecase.departamento.DepartamentoUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoUseCase departamentoUseCase;

    public DepartamentoController(DepartamentoUseCase departamentoUseCase) {
        this.departamentoUseCase = departamentoUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody DepartamentoRequest request) {
        departamentoUseCase.cadastrar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> buscarPorId(@PathVariable("id") Long id) {
        DepartamentoResponse response = departamentoUseCase.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DepartamentoResponse>> listar(DepartamentoFilter departamentoFilter, Pageable pageable) {
        Page<DepartamentoResponse> response = departamentoUseCase.listar(departamentoFilter, pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable("id") Long id, 
            @Valid @RequestBody DepartamentoUpdateRequest request) {
        departamentoUseCase.atualizar(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        departamentoUseCase.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/quantidade/{status}")
    public ResponseEntity<Integer> quantidadeAtivos(@PathVariable Boolean status) {
        return ResponseEntity.ok(departamentoUseCase.quantidadePorStatus(status));
    }
} 