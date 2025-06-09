package com.vilelatech.rh.common.validation;

import com.vilelatech.rh.domain.validation.EmailValidator;

/**
 * Validador específico de e-mail para uso em validações de negócio.
 * Encapsula a lógica de validação de e-mail com mensagens de erro específicas.
 */
public final class ValidadorEmail {
    
    private ValidadorEmail() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Valida um e-mail e retorna o resultado da validação.
     * 
     * @param email o e-mail a ser validado
     * @return resultado da validação
     */
    public static ResultadoValidacao validar(String email) {
        if (email == null || email.trim().isEmpty()) {
            return ResultadoValidacao.erro("E-mail é obrigatório");
        }
        
        if (!EmailValidator.isValido(email)) {
            return ResultadoValidacao.erro("E-mail inválido: " + email);
        }
        
        return ResultadoValidacao.sucesso();
    }
    
    /**
     * Valida um e-mail e lança exceção se inválido.
     * 
     * @param email o e-mail a ser validado
     * @throws IllegalArgumentException se o e-mail for inválido
     */
    public static void validarOuLancarExcecao(String email) {
        ResultadoValidacao resultado = validar(email);
        if (!resultado.isValido()) {
            throw new IllegalArgumentException(resultado.getMensagemErro());
        }
    }
    
    /**
     * Resultado de uma validação.
     */
    public static class ResultadoValidacao {
        private final boolean valido;
        private final String mensagemErro;
        
        private ResultadoValidacao(boolean valido, String mensagemErro) {
            this.valido = valido;
            this.mensagemErro = mensagemErro;
        }
        
        public static ResultadoValidacao sucesso() {
            return new ResultadoValidacao(true, null);
        }
        
        public static ResultadoValidacao erro(String mensagem) {
            return new ResultadoValidacao(false, mensagem);
        }
        
        public boolean isValido() {
            return valido;
        }
        
        public String getMensagemErro() {
            return mensagemErro;
        }
    }
} 