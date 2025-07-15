package com.vilelatech.rh.application.dto.cargo;

import com.vilelatech.rh.domain.model.enums.NivelCargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private NivelCargo nivel;
    private Long departamentoId;
    private String departamentoNome;
    private BigDecimal salarioBase;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
} 