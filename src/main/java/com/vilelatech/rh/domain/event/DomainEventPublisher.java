package com.vilelatech.rh.domain.event;

/**
 * Interface para publicação de eventos de domínio.
 * Implementa o padrão Observer para notificar sobre mudanças no domínio.
 */
public interface DomainEventPublisher {
    
    /**
     * Publica um evento de colaborador criado.
     * 
     * @param event o evento a ser publicado
     */
    void publish(ColaboradorCriadoEvent event);
    
    /**
     * Publica um evento de colaborador inativado.
     * 
     * @param event o evento a ser publicado
     */
    void publish(ColaboradorInativadoEvent event);
    
    /**
     * Publica um evento de registro de ponto lançado.
     * 
     * @param event o evento a ser publicado
     */
    void publish(RegistroPontoLancadoEvent event);
    
    /**
     * Publica qualquer evento de domínio genérico.
     * 
     * @param event o evento a ser publicado
     */
    void publishEvent(Object event);
} 