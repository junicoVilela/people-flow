package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_COLABORADOR")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;
    
    @Column(length = 14, unique = true, nullable = false)
    private String cpf;
    
    @Column(length = 20)
    private String rg;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(length = 10)
    private String sexo;
    
    @Column(length = 20)
    private String telefone;
    
    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;
    
    @Column(columnDefinition = "TEXT")
    private String endereco;
    
    @Column(length = 100)
    private String cargo;
    
    @Column(length = 100)
    private String departamento;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal salario;
    
    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;
    
    @Column(name = "data_demissao")
    private LocalDate dataDemissao;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;
    
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;
} 