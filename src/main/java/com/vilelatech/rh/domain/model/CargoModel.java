package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.NivelCargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CargoModel extends BaseModel {

    private Long id;
    private String nome;
    private String descricao;
    private NivelCargo nivel;
    private BigDecimal salarioBase;
    private Boolean ativo;

    private Long departamentoId;
}
