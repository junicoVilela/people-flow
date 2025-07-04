package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.StatusColaborador;
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
public class ColaboradorModel {
    private Long id;
    private Long usuarioId;
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
    private StatusColaborador status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private UsuarioModel usuario;
} 