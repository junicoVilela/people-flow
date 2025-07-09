package com.vilelatech.rh.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_JUSTIFICATIVA_PONTO")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class JustificativaPonto extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "REGISTRO_PONTO_ID", nullable = false)
    private Long registroPontoId;
    
    @Column(name = "MOTIVO", columnDefinition = "TEXT", nullable = false)
    private String motivo;
    
    @Column(name = "STATUS", length = 20, nullable = false)
    private String status;
    
    @Column(name = "DATA_ANALISE")
    private LocalDateTime dataAnalise;
    
    @Column(name = "ANALISTA_ID")
    private Long analistaId;
} 