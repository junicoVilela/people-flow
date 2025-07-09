package com.vilelatech.rh.application.exception;

public class ConflitoConcorrenciaException extends RuntimeException {
    
    public ConflitoConcorrenciaException(String message) {
        super(message);
    }
    
    public ConflitoConcorrenciaException(String message, Throwable cause) {
        super(message, cause);
    }
} 