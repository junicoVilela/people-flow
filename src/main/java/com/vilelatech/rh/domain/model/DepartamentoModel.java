package com.vilelatech.rh.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoModel extends BaseModel {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean ativo;
}
