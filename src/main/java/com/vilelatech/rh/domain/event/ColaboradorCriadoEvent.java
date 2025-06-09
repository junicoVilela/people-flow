package com.vilelatech.rh.domain.event;

import java.time.LocalDateTime;

/**
 * Evento de domínio disparado quando um novo colaborador é criado.
 * Permite que outras partes do sistema reajam a esta criação.
 */
public record ColaboradorCriadoEvent(
    Long colaboradorId,
    String nome,
    String email,
    String cargo,
    String departamento,
    LocalDateTime dataEvento
) {
    
    public static ColaboradorCriadoEvent criar(Long colaboradorId, String nome, String email, 
                                              String cargo, String departamento) {
        return new ColaboradorCriadoEvent(
            colaboradorId, 
            nome, 
            email, 
            cargo, 
            departamento, 
            LocalDateTime.now()
        );
    }
} 