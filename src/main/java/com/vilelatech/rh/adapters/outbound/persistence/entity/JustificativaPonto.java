package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.StatusJustificativa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_JUSTIFICATIVA_PONTO")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JustificativaPonto extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "registro_ponto_id", nullable = false)
    private RegistroPonto registroPonto;
    
    @Column(name = "MOTIVO", columnDefinition = "TEXT", nullable = false)
    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",nullable = false)
    private StatusJustificativa status;
    
    @Column(name = "DATA_ANALISE")
    private LocalDateTime dataAnalise;

    @ManyToOne
    @JoinColumn(name = "analista_id")
    private Usuario analista;
} 