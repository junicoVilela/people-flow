package com.vilelatech.rh.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Utilitário para manipulação e formatação de datas.
 * Centraliza operações comuns relacionadas a datas no sistema.
 */
public final class DateUtil {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    private DateUtil() {
        // Classe utilitária - construtor privado
    }
    
    /**
     * Formata uma data para o padrão brasileiro (dd/MM/yyyy).
     */
    public static String formatarData(LocalDate data) {
        return data != null ? data.format(DATE_FORMATTER) : null;
    }
    
    /**
     * Formata uma data e hora para o padrão brasileiro (dd/MM/yyyy HH:mm:ss).
     */
    public static String formatarDataHora(LocalDateTime dataHora) {
        return dataHora != null ? dataHora.format(DATETIME_FORMATTER) : null;
    }
    
    /**
     * Calcula a idade com base na data de nascimento.
     */
    public static int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    
    /**
     * Verifica se uma data é futura em relação à data atual.
     */
    public static boolean isFutura(LocalDate data) {
        return data.isAfter(LocalDate.now());
    }
    
    /**
     * Verifica se uma data e hora é futura em relação ao momento atual.
     */
    public static boolean isFutura(LocalDateTime dataHora) {
        return dataHora.isAfter(LocalDateTime.now());
    }
    
    /**
     * Verifica se uma pessoa é maior de idade (18 anos ou mais).
     */
    public static boolean isMaiorDeIdade(LocalDate dataNascimento) {
        return calcularIdade(dataNascimento) >= 18;
    }
} 