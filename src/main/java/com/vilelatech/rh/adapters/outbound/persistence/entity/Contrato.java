package com.vilelatech.rh.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_CONTRATO")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Contrato extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "COLABORADOR_ID", nullable = false)
    private Long colaboradorId;
    
    @Column(name = "TIPO_CONTRATO", length = 50, nullable = false)
    private String tipoContrato;
    
    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;
    
    @Column(name = "DATA_FIM")
    private LocalDate dataFim;
    
    @Column(name = "SALARIO", precision = 10, scale = 2, nullable = false)
    private BigDecimal salario;
    
    @Column(name = "CARGA_HORARIA_SEMANAL", nullable = false)
    private Integer cargaHorariaSemanal;
    
    @Column(name = "STATUS", length = 20, nullable = false)
    private String status;
} 