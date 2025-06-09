package com.vilelatech.rh.application.dto.colaborador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorUpdateRequest {
    private String nome;
    private String telefone;
    private String endereco;
    private String cargo;
    private String departamento;
    private BigDecimal salario;
} 