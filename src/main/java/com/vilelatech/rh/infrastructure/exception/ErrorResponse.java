package com.vilelatech.rh.infrastructure.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que padroniza as respostas de erro da API.
 * Segue o padrão RFC 7807 (Problem Details for HTTP APIs).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    
    /**
     * Timestamp do erro
     */
    private LocalDateTime timestamp;
    
    /**
     * Código de status HTTP
     */
    private Integer status;
    
    /**
     * Tipo do erro (resumo)
     */
    private String error;
    
    /**
     * Mensagem detalhada do erro
     */
    private String message;
    
    /**
     * Lista de detalhes adicionais (opcional)
     * Útil para erros de validação com múltiplos campos
     */
    private List<String> details;
    
    /**
     * Path da requisição onde ocorreu o erro (opcional)
     */
    private String path;
    
    /**
     * Construtor para erros simples
     */
    public ErrorResponse(String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.error = error;
        this.message = message;
    }
    
    /**
     * Construtor para erros com status HTTP
     */
    public ErrorResponse(Integer status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }
} 