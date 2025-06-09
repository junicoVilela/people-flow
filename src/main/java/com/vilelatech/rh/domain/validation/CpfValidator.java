package com.vilelatech.rh.domain.validation;

/**
 * Validador de CPF como regra de negócio crítica do domínio.
 * Implementa o algoritmo oficial de validação de Cadastro de Pessoa Física.
 */
public final class CpfValidator {
    
    private CpfValidator() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Valida se um CPF é válido segundo o algoritmo oficial.
     * 
     * @param cpf o CPF a ser validado (com ou sem formatação)
     * @return true se o CPF for válido, false caso contrário
     */
    public static boolean isValido(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }
        
        // Remove formatação
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) {
                primeiroDigito = 0;
            }
            
            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) {
                segundoDigito = 0;
            }
            
            // Verifica se os dígitos calculados conferem
            return primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                   segundoDigito == Character.getNumericValue(cpf.charAt(10));
                   
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Formata um CPF adicionando pontos e hífen.
     * 
     * @param cpf o CPF a ser formatado
     * @return o CPF formatado no padrão XXX.XXX.XXX-XX
     */
    public static String formatar(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return cpf;
        }
        
        cpf = cpf.replaceAll("[^0-9]", "");
        
        if (cpf.length() != 11) {
            return cpf;
        }
        
        return cpf.substring(0, 3) + "." + 
               cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + 
               cpf.substring(9, 11);
    }
} 