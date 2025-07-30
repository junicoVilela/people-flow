package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.application.usecase.colaborador.ColaboradorUseCase;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {
    
    private final ColaboradorUseCase colaboradorUseCase;
    
    public ColaboradorController(ColaboradorUseCase colaboradorUseCase) {
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
    public ResponseEntity<Page<ColaboradorResponse>> listar(ColaboradorFilter colaboradorFilter, Pageable pageable) {

        Page<ColaboradorResponse> response = colaboradorUseCase.listar(colaboradorFilter, pageable);
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

    @GetMapping("/quantidade/{status}")
    public ResponseEntity<Long> quantidadeAtivos(@PathVariable StatusColaborador status) {
        return ResponseEntity.ok(colaboradorUseCase.quantidadePorStatus(status));
    }

} 