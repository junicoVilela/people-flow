package com.vilelatech.rh.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPonto {
    private Long id;
    private Long colaboradorId;
    private LocalDate dataRegistro;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private BigDecimal totalHoras;
    private String observacao;
    private TipoRegistro tipoRegistro;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
} 