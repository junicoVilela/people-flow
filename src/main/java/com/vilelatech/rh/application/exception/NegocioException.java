package com.vilelatech.rh.application.exception;

/**
 * Exceção lançada quando uma regra de negócio é violada.
 * Esta é uma exceção de aplicação que representa um erro de validação de negócio.
 */
public class NegocioException extends RuntimeException {
    
    public NegocioException(String mensagem) {
        super(mensagem);
    }
    
    public NegocioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
} 