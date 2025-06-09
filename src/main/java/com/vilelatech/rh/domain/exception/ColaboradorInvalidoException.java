package com.vilelatech.rh.domain.exception;

/**
 * Exceção de domínio lançada quando um colaborador não atende às regras de negócio.
 * Esta é uma exceção de domínio que representa uma violação de invariantes.
 */
public class ColaboradorInvalidoException extends RuntimeException {
    
    public ColaboradorInvalidoException(String mensagem) {
        super(mensagem);
    }
    
    public ColaboradorInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
    public static ColaboradorInvalidoException cpfInvalido(String cpf) {
        return new ColaboradorInvalidoException("CPF inválido: " + cpf);
    }
    
    public static ColaboradorInvalidoException emailInvalido(String email) {
        return new ColaboradorInvalidoException("E-mail inválido: " + email);
    }
    
    public static ColaboradorInvalidoException idadeInvalida(int idade) {
        return new ColaboradorInvalidoException("Idade inválida para colaborador: " + idade);
    }
} 