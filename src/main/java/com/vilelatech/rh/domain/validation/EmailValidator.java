package com.vilelatech.rh.domain.validation;

import java.util.regex.Pattern;

/**
 * Validador de e-mail como regra de negócio crítica do domínio.
 * Implementa validação usando expressões regulares.
 */
public final class EmailValidator {
    
    private static final String EMAIL_PATTERN = 
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
    private static final Pattern EMAIL_REGEX = Pattern.compile(EMAIL_PATTERN);
    
    private EmailValidator() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Valida se um e-mail possui formato válido.
     * 
     * @param email o e-mail a ser validado
     * @return true se o e-mail for válido, false caso contrário
     */
    public static boolean isValido(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        email = email.trim().toLowerCase();
        
        return EMAIL_REGEX.matcher(email).matches();
    }
    
    /**
     * Normaliza um e-mail removendo espaços e convertendo para minúsculas.
     * 
     * @param email o e-mail a ser normalizado
     * @return o e-mail normalizado
     */
    public static String normalizar(String email) {
        if (email == null) {
            return null;
        }
        
        return email.trim().toLowerCase();
    }
    
    /**
     * Extrai o domínio de um e-mail.
     * 
     * @param email o e-mail
     * @return o domínio do e-mail ou null se inválido
     */
    public static String extrairDominio(String email) {
        if (!isValido(email)) {
            return null;
        }
        
        int atIndex = email.indexOf('@');
        return email.substring(atIndex + 1);
    }
} 