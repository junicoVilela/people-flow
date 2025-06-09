package com.vilelatech.rh.domain.exception;

import java.time.LocalDateTime;

/**
 * Exceção de domínio lançada quando um registro de ponto não atende às regras de negócio.
 * Esta é uma exceção de domínio que representa uma violação de invariantes.
 */
public class RegistroPontoInvalidoException extends RuntimeException {
    
    public RegistroPontoInvalidoException(String mensagem) {
        super(mensagem);
    }
    
    public RegistroPontoInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
    public static RegistroPontoInvalidoException dataFutura(LocalDateTime dataHora) {
        return new RegistroPontoInvalidoException(
            "Não é possível registrar ponto com data futura: " + dataHora
        );
    }
    
    public static RegistroPontoInvalidoException intervaloPequenoEntrePontos(int minutos) {
        return new RegistroPontoInvalidoException(
            "Intervalo muito pequeno entre registros de ponto: " + minutos + " minutos"
        );
    }
    
    public static RegistroPontoInvalidoException colaboradorNaoEncontrado(Long colaboradorId) {
        return new RegistroPontoInvalidoException(
            "Colaborador não encontrado para o ID: " + colaboradorId
        );
    }
} 