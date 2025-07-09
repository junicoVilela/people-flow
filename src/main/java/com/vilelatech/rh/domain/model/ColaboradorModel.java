package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel extends BaseModel {
    private Long id;
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

    private Long usuarioId;
    private UsuarioModel usuario;
} 