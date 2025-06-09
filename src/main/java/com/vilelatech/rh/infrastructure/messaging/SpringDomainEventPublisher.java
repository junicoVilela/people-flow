package com.vilelatech.rh.infrastructure.messaging;

import com.vilelatech.rh.domain.event.ColaboradorCriadoEvent;
import com.vilelatech.rh.domain.event.ColaboradorInativadoEvent;
import com.vilelatech.rh.domain.event.DomainEventPublisher;
import com.vilelatech.rh.domain.event.RegistroPontoLancadoEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Implementação do DomainEventPublisher usando o Spring ApplicationEventPublisher.
 * Permite a publicação de eventos de domínio através do mecanismo de eventos do Spring.
 */
/*@Component
public class SpringDomainEventPublisher implements DomainEventPublisher {
    
    private final ApplicationEventPublisher applicationEventPublisher;
    
    public SpringDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    @Override
    public void publish(ColaboradorCriadoEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
    
    @Override
    public void publish(ColaboradorInativadoEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
    
    @Override
    public void publish(RegistroPontoLancadoEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
    
    @Override
    public void publishEvent(Object event) {
        applicationEventPublisher.publishEvent(event);
    }
}*/