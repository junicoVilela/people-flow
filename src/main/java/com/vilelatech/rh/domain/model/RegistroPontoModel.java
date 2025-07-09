package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.TipoRegistro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPontoModel extends BaseModel {
    private Long id;
    private Long colaboradorId;
    private LocalDate dataRegistro;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private BigDecimal totalHoras;
    private String observacao;
    private TipoRegistro tipoRegistro;
} 