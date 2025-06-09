package com.vilelatech.rh.application.exception;

/**
 * Exceção lançada quando há falhas no processo de autenticação.
 * Esta é uma exceção de aplicação que representa erros de autenticação.
 */
public class AutenticacaoException extends RuntimeException {
    
    public AutenticacaoException(String mensagem) {
        super(mensagem);
    }
    
    public AutenticacaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
} 