package com.vilelatech.rh.application.dto.cargo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoFilter {

    private String nome;
    private String departamento;
    private String status;
} 