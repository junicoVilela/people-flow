package com.vilelatech.rh.common.validation;

import com.vilelatech.rh.domain.validation.CpfValidator;

/**
 * Validador específico de CPF para uso em validações de negócio.
 * Encapsula a lógica de validação de CPF com mensagens de erro específicas.
 */
public final class ValidadorCpf {
    
    private ValidadorCpf() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Valida um CPF e retorna o resultado da validação.
     * 
     * @param cpf o CPF a ser validado
     * @return resultado da validação
     */
    public static ResultadoValidacao validar(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return ResultadoValidacao.erro("CPF é obrigatório");
        }
        
        if (!CpfValidator.isValido(cpf)) {
            return ResultadoValidacao.erro("CPF inválido: " + cpf);
        }
        
        return ResultadoValidacao.sucesso();
    }
    
    /**
     * Valida um CPF e lança exceção se inválido.
     * 
     * @param cpf o CPF a ser validado
     * @throws IllegalArgumentException se o CPF for inválido
     */
    public static void validarOuLancarExcecao(String cpf) {
        ResultadoValidacao resultado = validar(cpf);
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