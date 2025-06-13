package com.vilelatech.rh.application.dto.colaborador;

import com.vilelatech.rh.domain.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorResponse {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;
    private String estadoCivil;
    private String endereco;
    private String cargo;
    private String departamento;
    private BigDecimal salario;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private Status status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
} 