package com.vilelatech.rh.adapters.outbound.messaging.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Produtor de eventos Kafka para eventos relacionados a registro de ponto.
 * Responsável por publicar eventos de registro de ponto no Apache Kafka.
 */
@Component
public class RegistroPontoEventProducer {
    
    private static final Logger log = LoggerFactory.getLogger(RegistroPontoEventProducer.class);
    private static final String REGISTRO_PONTO_TOPIC = "registro-ponto-lancado";
    
    /*private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public RegistroPontoEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void publishRegistroPontoLancado(RegistroPontoLancadoEvent event) {
        try {
            String key = event.colaboradorId().toString();
            kafkaTemplate.send(REGISTRO_PONTO_TOPIC, key, event);
            log.info("Evento RegistroPontoLancado publicado para Colaborador ID: {} - Registro ID: {}", 
                    event.colaboradorId(), event.registroId());
        } catch (Exception e) {
            log.error("Erro ao publicar evento RegistroPontoLancado para Colaborador ID: {} - Registro ID: {}", 
                    event.colaboradorId(), event.registroId(), e);
            throw new RuntimeException("Falha ao publicar evento no Kafka", e);
        }
    }*/
} 