package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.NivelCargo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoModel {

    private Long id;
    private String nome;
    private String descricao;
    private NivelCargo nivel;
    private BigDecimal salarioBase;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private Long departamentoId;
    private DepartamentoModel departamento;
}
