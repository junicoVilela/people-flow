package com.vilelatech.rh.domain.event;

import com.vilelatech.rh.domain.model.TipoRegistro;
import java.time.LocalDateTime;

/**
 * Evento de domínio disparado quando um registro de ponto é lançado.
 * Permite que outras partes do sistema reajam a este lançamento.
 */
public record RegistroPontoLancadoEvent(
    Long registroId,
    Long colaboradorId,
    String nomeColaborador,
    TipoRegistro tipoRegistro,
    LocalDateTime dataHoraRegistro,
    LocalDateTime dataEvento
) {
    
    public static RegistroPontoLancadoEvent criar(Long registroId, Long colaboradorId, 
                                                 String nomeColaborador, TipoRegistro tipoRegistro, 
                                                 LocalDateTime dataHoraRegistro) {
        return new RegistroPontoLancadoEvent(
            registroId, 
            colaboradorId, 
            nomeColaborador, 
            tipoRegistro, 
            dataHoraRegistro, 
            LocalDateTime.now()
        );
    }
} 