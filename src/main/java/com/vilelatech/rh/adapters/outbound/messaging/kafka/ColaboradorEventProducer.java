package com.vilelatech.rh.adapters.outbound.messaging.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Produtor de eventos Kafka para eventos relacionados a colaboradores.
 * Responsável por publicar eventos de colaborador no Apache Kafka.
 */
@Component
public class ColaboradorEventProducer {
    
    private static final Logger log = LoggerFactory.getLogger(ColaboradorEventProducer.class);
    private static final String COLABORADOR_CRIADO_TOPIC = "colaborador-criado";
    private static final String COLABORADOR_INATIVADO_TOPIC = "colaborador-inativado";
    
    /*private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public ColaboradorEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void publishColaboradorCriado(ColaboradorCriadoEvent event) {
        try {
            kafkaTemplate.send(COLABORADOR_CRIADO_TOPIC, event.colaboradorId().toString(), event);
            log.info("Evento ColaboradorCriado publicado para ID: {}", event.colaboradorId());
        } catch (Exception e) {
            log.error("Erro ao publicar evento ColaboradorCriado para ID: {}", event.colaboradorId(), e);
            throw new RuntimeException("Falha ao publicar evento no Kafka", e);
        }
    }
    
    public void publishColaboradorInativado(ColaboradorInativadoEvent event) {
        try {
            kafkaTemplate.send(COLABORADOR_INATIVADO_TOPIC, event.colaboradorId().toString(), event);
            log.info("Evento ColaboradorInativado publicado para ID: {}", event.colaboradorId());
        } catch (Exception e) {
            log.error("Erro ao publicar evento ColaboradorInativado para ID: {}", event.colaboradorId(), e);
            throw new RuntimeException("Falha ao publicar evento no Kafka", e);
        }
    }*/
} 