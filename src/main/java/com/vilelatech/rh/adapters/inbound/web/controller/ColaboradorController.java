package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.application.usecase.colaborador.ColaboradorUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST para operações de colaboradores.
 * Adapter de entrada para casos de uso de colaborador.
 */
@RestController
@RequestMapping("/api/colaboradores")
@CrossOrigin(origins = "*")
public class ColaboradorController {
    
    private final ColaboradorUseCase colaboradorUseCase;
    
    public ColaboradorController(ColaboradorUseCase colaboradorUseCase) {
        this.colaboradorUseCase = colaboradorUseCase;
    }
    
    /**
     * Endpoint para criar um novo colaborador.
     * 
     * @param request dados do colaborador
     * @return colaborador criado
     */
    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody ColaboradorRequest request) {
        colaboradorUseCase.cadastrar(request);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Endpoint para buscar colaborador por ID.
     * 
     * @param id ID do colaborador
     * @return dados do colaborador
     */
    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorResponse> buscarPorId(@PathVariable Long id) {

        ColaboradorResponse response = colaboradorUseCase.buscarPorId(id);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Endpoint para listar colaboradores com paginação.
     * 
     * @param pageable parâmetros de paginação
     * @return página de colaboradores
     */
    @GetMapping
    public ResponseEntity<Page<ColaboradorResponse>> listar(Pageable pageable) {

        Page<ColaboradorResponse> response = colaboradorUseCase.listar(pageable);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Endpoint para atualizar um colaborador.
     * 
     * @param id ID do colaborador
     * @param request dados para atualização
     * @return colaborador atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable Long id, 
            @RequestBody ColaboradorUpdateRequest request) {

        colaboradorUseCase.atualizar(id, request);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Endpoint para inativar um colaborador.
     * 
     * @param id ID do colaborador
     * @param request dados de inativação
     * @return confirmação de inativação
     */
    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(
            @PathVariable Long id, 
            @RequestBody InativacaoRequest request) {

        colaboradorUseCase.inativar(id, request);
        return ResponseEntity.noContent().build();
    }
} 