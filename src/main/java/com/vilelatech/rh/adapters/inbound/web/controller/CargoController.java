package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.cargo.CargoFilter;
import com.vilelatech.rh.application.dto.cargo.CargoRequest;
import com.vilelatech.rh.application.dto.cargo.CargoResponse;
import com.vilelatech.rh.application.usecase.cargo.CargoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoUseCase cargoUseCase;

    @GetMapping
    public ResponseEntity<Page<CargoResponse>> listar(CargoFilter cargoFilter, Pageable pageable) {
        Page<CargoResponse> response = cargoUseCase.listar(cargoFilter, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoResponse> buscarPorId(@PathVariable Long id) {
        CargoResponse cargo = cargoUseCase.buscarPorId(id);
        return ResponseEntity.ok(cargo);
    }

    @PostMapping
    public ResponseEntity<CargoResponse> criar(@Valid @RequestBody CargoRequest request) {
        cargoUseCase.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CargoRequest request) {
        cargoUseCase.atualizar(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cargoUseCase.inativar(id);
        return ResponseEntity.noContent().build();
    }
} 