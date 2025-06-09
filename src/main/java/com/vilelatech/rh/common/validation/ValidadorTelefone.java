package com.vilelatech.rh.common.validation;

import java.util.regex.Pattern;

/**
 * Validador específico de telefone para uso em validações de negócio.
 * Encapsula a lógica de validação de telefone com mensagens de erro específicas.
 */
public final class ValidadorTelefone {
    
    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\(?[1-9]{2}\\)?\\s?[0-9]{4,5}-?[0-9]{4}$");
    
    private ValidadorTelefone() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Valida um telefone e retorna o resultado da validação.
     * 
     * @param telefone o telefone a ser validado
     * @return resultado da validação
     */
    public static ResultadoValidacao validar(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return ResultadoValidacao.erro("Telefone é obrigatório");
        }
        
        String telefoneNumeros = telefone.replaceAll("[^0-9]", "");
        
        if (telefoneNumeros.length() < 10 || telefoneNumeros.length() > 11) {
            return ResultadoValidacao.erro("Telefone deve ter 10 ou 11 dígitos: " + telefone);
        }
        
        if (!TELEFONE_PATTERN.matcher(telefone).matches()) {
            return ResultadoValidacao.erro("Formato de telefone inválido: " + telefone);
        }
        
        return ResultadoValidacao.sucesso();
    }
    
    /**
     * Valida um telefone e lança exceção se inválido.
     * 
     * @param telefone o telefone a ser validado
     * @throws IllegalArgumentException se o telefone for inválido
     */
    public static void validarOuLancarExcecao(String telefone) {
        ResultadoValidacao resultado = validar(telefone);
        if (!resultado.isValido()) {
            throw new IllegalArgumentException(resultado.getMensagemErro());
        }
    }
    
    /**
     * Formata um telefone no padrão brasileiro.
     * 
     * @param telefone o telefone a ser formatado
     * @return o telefone formatado
     */
    public static String formatar(String telefone) {
        if (telefone == null) {
            return null;
        }
        
        String numeros = telefone.replaceAll("[^0-9]", "");
        
        if (numeros.length() == 10) {
            return String.format("(%s) %s-%s", 
                numeros.substring(0, 2), 
                numeros.substring(2, 6), 
                numeros.substring(6));
        } else if (numeros.length() == 11) {
            return String.format("(%s) %s-%s", 
                numeros.substring(0, 2), 
                numeros.substring(2, 7), 
                numeros.substring(7));
        }
        
        return telefone;
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