package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.TipoRegistro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "TB_REGISTRO_PONTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPonto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "colaborador_id", nullable = false)
    private Long colaboradorId;
    
    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;
    
    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;
    
    @Column(name = "hora_saida")
    private LocalTime horaSaida;
    
    @Column(name = "total_horas", precision = 5, scale = 2)
    private BigDecimal totalHoras;
    
    @Column
    private String observacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_registro", length = 20, nullable = false)
    private TipoRegistro tipoRegistro;
    
    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;
    
    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;
} 