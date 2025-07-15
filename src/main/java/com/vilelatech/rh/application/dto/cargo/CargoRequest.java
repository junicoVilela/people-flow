package com.vilelatech.rh.application.dto.cargo;

import com.vilelatech.rh.domain.model.enums.NivelCargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @Size(max = 250, message = "Descrição deve ter no máximo 250 caracteres")
    private String descricao;

    @NotNull(message = "Nível é obrigatório")
    private NivelCargo nivel;

    @NotNull(message = "Departamento é obrigatório")
    private Long departamentoId;

    @NotNull(message = "Salário base é obrigatório")
    @Positive(message = "Salário base deve ser positivo")
    private BigDecimal salarioBase;

    private Boolean ativo = true;
} 