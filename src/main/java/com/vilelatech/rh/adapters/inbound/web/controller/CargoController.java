package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.cargo.CargoRequest;
import com.vilelatech.rh.application.dto.cargo.CargoResponse;
import com.vilelatech.rh.application.usecase.cargo.CargoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<CargoResponse>> listar() {
        List<CargoResponse> cargos = cargoUseCase.listar();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoResponse> buscarPorId(@PathVariable Long id) {
        CargoResponse cargo = cargoUseCase.buscarPorId(id);
        return ResponseEntity.ok(cargo);
    }

    @PostMapping
    public ResponseEntity<CargoResponse> criar(@Valid @RequestBody CargoRequest request) {
        CargoResponse cargo = cargoUseCase.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CargoRequest request) {
        CargoResponse cargo = cargoUseCase.atualizar(id, request);
        return ResponseEntity.ok(cargo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cargoUseCase.inativar(id);
        return ResponseEntity.noContent().build();
    }
} 