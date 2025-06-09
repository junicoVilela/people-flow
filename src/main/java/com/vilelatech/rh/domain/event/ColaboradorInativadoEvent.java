package com.vilelatech.rh.domain.event;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Evento de domínio disparado quando um colaborador é inativado.
 * Permite que outras partes do sistema reajam a esta inativação.
 */
public record ColaboradorInativadoEvent(
    Long colaboradorId,
    String nome,
    String motivo,
    LocalDate dataDemissao,
    LocalDateTime dataEvento
) {
    
    public static ColaboradorInativadoEvent criar(Long colaboradorId, String nome, 
                                                 String motivo, LocalDate dataDemissao) {
        return new ColaboradorInativadoEvent(
            colaboradorId, 
            nome, 
            motivo, 
            dataDemissao, 
            LocalDateTime.now()
        );
    }
} 