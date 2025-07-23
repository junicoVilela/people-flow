package com.vilelatech.rh.application.dto.colaborador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorUpdateRequest {
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;
    
    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    @Pattern(regexp = "\\d{10,11}|", message = "Telefone deve ter 10 ou 11 dígitos")
    private String telefone;
    
    @Size(max = 200, message = "Endereço deve ter no máximo 200 caracteres")
    private String endereco;
    
    @NotNull(message = "Cargo é obrigatório")
    private Long cargoId;
    
    @NotNull(message = "Departamento é obrigatório")
    private Long departamentoId;
    
    @NotNull(message = "Salário é obrigatório")
    @DecimalMin(value = "0.01", message = "Salário deve ser maior que zero")
    @Digits(integer = 10, fraction = 2, message = "Salário deve ter no máximo 10 dígitos inteiros e 2 decimais")
    private BigDecimal salario;
    
    private LocalDate dataDemissao;
    
    @NotNull(message = "Status é obrigatório")
    private StatusColaborador status;
} 