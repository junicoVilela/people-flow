package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_COLABORADOR")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador extends BaseEntity {
    
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
    
    @Column(name = "CARGO_ID")
    private Long cargoId;
    
    @Column(name = "DEPARTAMENTO_ID")
    private Long departamentoId;
    
    @Column(name = "SALARIO", precision = 10, scale = 2)
    private BigDecimal salario;
    
    @Column(name = "DATA_ADMISSAO")
    private LocalDate dataAdmissao;
    
    @Column(name = "DATA_DEMISSAO")
    private LocalDate dataDemissao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 20)
    private StatusColaborador status;
    
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID", insertable = false, updatable = false)
    private Usuario usuario;
} 