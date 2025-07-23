package com.vilelatech.rh.application.dto.colaborador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorFilter {
    private String nome;
    private String cargo;
    private String departamento;
    private String status;
}