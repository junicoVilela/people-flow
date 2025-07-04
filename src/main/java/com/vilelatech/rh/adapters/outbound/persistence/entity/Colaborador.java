package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.StatusColaborador;
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
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "CPF", length = 14, unique = true, nullable = false)
    private String cpf;
    
    @Column(name = "RG", length = 20)
    private String rg;
    
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    
    @Column(name = "SEXO", length = 10)
    private String sexo;
    
    @Column(name = "TELEFONE", length = 20)
    private String telefone;
    
    @Column(name = "ESTADO_CIVIL", length = 20)
    private String estadoCivil;
    
    @Column(name = "ENDERECO", columnDefinition = "TEXT")
    private String endereco;
    
    @Column(name = "CARGO", length = 100)
    private String cargo;
    
    @Column(name = "DEPARTAMENTO", length = 100)
    private String departamento;
    
    @Column(name = "SALARIO", precision = 10, scale = 2)
    private BigDecimal salario;
    
    @Column(name = "DATA_ADMISSAO")
    private LocalDate dataAdmissao;
    
    @Column(name = "DATA_DEMISSAO")
    private LocalDate dataDemissao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 20)
    private StatusColaborador status;
    
    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID", insertable = false, updatable = false)
    private Usuario usuario;
} 