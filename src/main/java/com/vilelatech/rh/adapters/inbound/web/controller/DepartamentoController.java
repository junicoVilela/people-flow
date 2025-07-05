package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.application.usecase.colaborador.ColaboradorUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final ColaboradorUseCase colaboradorUseCase;

    public DepartamentoController(ColaboradorUseCase colaboradorUseCase) {
        this.colaboradorUseCase = colaboradorUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody ColaboradorRequest request) {
        colaboradorUseCase.cadastrar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorResponse> buscarPorId(@PathVariable("id") Long id) {

        ColaboradorResponse response = colaboradorUseCase.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ColaboradorResponse>> listar(Pageable pageable) {

        Page<ColaboradorResponse> response = colaboradorUseCase.listar(pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable("id") Long id, 
            @Valid @RequestBody ColaboradorUpdateRequest request) {

        colaboradorUseCase.atualizar(id, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(
            @PathVariable("id") Long id, 
            @RequestBody InativacaoRequest request) {

        colaboradorUseCase.inativar(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        colaboradorUseCase.excluir(id);
        return ResponseEntity.noContent().build();
    }
} 