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
public class ColaboradorRequest {
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ter formato válido")
    @Size(max = 150, message = "Email deve ter no máximo 150 caracteres")
    private String email;
    
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 20, message = "Senha deve ter entre 6 e 20 caracteres")
    private String senha;
    
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;
    
    @Size(max = 20, message = "RG deve ter no máximo 20 caracteres")
    private String rg;
    
    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    private LocalDate dataNascimento;
    
    @Size(max = 1, message = "Sexo deve ter 1 caractere (M/F)")
    @Pattern(regexp = "[MF]?", message = "Sexo deve ser M (Masculino) ou F (Feminino)")
    private String sexo;
    
    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    @Pattern(regexp = "\\d{10,11}|", message = "Telefone deve ter 10 ou 11 dígitos")
    private String telefone;
    
    @Size(max = 50, message = "Estado civil deve ter no máximo 50 caracteres")
    private String estadoCivil;
    
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
    
    @NotNull(message = "Data de admissão é obrigatória")
    private LocalDate dataAdmissao;
    
    private LocalDate dataDemissao;
    
    @NotNull(message = "Status é obrigatório")
    private StatusColaborador status;
} 