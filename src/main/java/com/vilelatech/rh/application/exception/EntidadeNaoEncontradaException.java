package com.vilelatech.rh.application.exception;

/**
 * Exceção lançada quando uma entidade não é encontrada na base de dados.
 * Esta é uma exceção de aplicação que representa um erro de busca.
 */
public class EntidadeNaoEncontradaException extends RuntimeException {
    
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    
    public EntidadeNaoEncontradaException(String entidade, Object id) {
        super(String.format("%s com ID %s não foi encontrado(a)", entidade, id));
    }
    
    public EntidadeNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
} 