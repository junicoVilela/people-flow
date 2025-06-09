package com.vilelatech.rh.infrastructure.messaging;

import com.vilelatech.rh.domain.event.DomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Configuração para publicação de eventos de domínio.
 * Define qual implementação usar para publicar eventos.
 */
/*
@Configuration
public class EventPublisherConfig {
    
    */
/**
     * Implementação padrão do DomainEventPublisher usando o Spring ApplicationEventPublisher.
     *//*

    @Bean
    @Primary
    public DomainEventPublisher springDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringDomainEventPublisher(applicationEventPublisher);
    }
} */
