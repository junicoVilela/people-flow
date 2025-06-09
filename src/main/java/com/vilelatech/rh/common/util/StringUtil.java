package com.vilelatech.rh.common.util;

/**
 * Utilitário para manipulação de strings.
 * Centraliza operações comuns relacionadas a strings no sistema.
 */
public final class StringUtil {
    
    private StringUtil() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Verifica se uma string é nula ou vazia.
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Verifica se uma string não é nula nem vazia.
     */
    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }
    
    /**
     * Capitaliza a primeira letra de uma string.
     */
    public static String capitalize(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    /**
     * Remove todos os caracteres não numéricos de uma string.
     */
    public static String somenteNumeros(String str) {
        if (str == null) {
            return null;
        }
        
        return str.replaceAll("[^0-9]", "");
    }
    
    /**
     * Formata um nome próprio (primeira letra de cada palavra maiúscula).
     */
    public static String formatarNome(String nome) {
        if (isNullOrEmpty(nome)) {
            return nome;
        }
        
        String[] palavras = nome.trim().toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        
        for (int i = 0; i < palavras.length; i++) {
            if (i > 0) {
                nomeFormatado.append(" ");
            }
            nomeFormatado.append(capitalize(palavras[i]));
        }
        
        return nomeFormatado.toString();
    }
} 