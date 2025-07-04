package com.vilelatech.rh.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DEPARTAMENTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 250)
    private String descricao;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}
