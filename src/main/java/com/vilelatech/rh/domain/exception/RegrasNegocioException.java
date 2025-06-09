package com.vilelatech.rh.domain.exception;

/**
 * Exceção genérica de domínio para violações de regras de negócio.
 * Esta é uma exceção de domínio que representa violações de invariantes gerais.
 */
public class RegrasNegocioException extends RuntimeException {
    
    public RegrasNegocioException(String mensagem) {
        super(mensagem);
    }
    
    public RegrasNegocioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
    public static RegrasNegocioException salarioInvalido(double salario) {
        return new RegrasNegocioException("Salário deve ser maior que zero: " + salario);
    }
    
    public static RegrasNegocioException dataAdmissaoInvalida(String motivo) {
        return new RegrasNegocioException("Data de admissão inválida: " + motivo);
    }
    
    public static RegrasNegocioException operacaoNaoPermitida(String operacao) {
        return new RegrasNegocioException("Operação não permitida: " + operacao);
    }
} 