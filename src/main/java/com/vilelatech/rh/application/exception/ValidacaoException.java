package com.vilelatech.rh.application.exception;

import java.util.List;

/**
 * Exceção lançada quando dados de entrada não passam nas validações.
 * Esta é uma exceção de aplicação que representa erros de validação.
 */
public class ValidacaoException extends RuntimeException {
    
    private final List<String> erros;
    
    public ValidacaoException(String mensagem) {
        super(mensagem);
        this.erros = List.of(mensagem);
    }
    
    public ValidacaoException(List<String> erros) {
        super("Erros de validação encontrados");
        this.erros = erros;
    }
    
    public List<String> getErros() {
        return erros;
    }
} 