package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.TipoRegistro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TB_REGISTRO_PONTO")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPonto extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "COLABORADOR_ID", nullable = false)
    private Long colaboradorId;
    
    @Column(name = "DATA_REGISTRO", nullable = false)
    private LocalDate dataRegistro;
    
    @Column(name = "HORA_ENTRADA")
    private LocalTime horaEntrada;
    
    @Column(name = "HORA_SAIDA")
    private LocalTime horaSaida;
    
    @Column(name = "TOTAL_HORAS", precision = 5, scale = 2)
    private BigDecimal totalHoras;
    
    @Column(name = "OBSERVACAO")
    private String observacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_REGISTRO", length = 20, nullable = false)
    private TipoRegistro tipoRegistro;
} 