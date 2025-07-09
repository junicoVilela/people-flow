package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.NivelCargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_CARGO")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 250)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "NIVEL")
    private NivelCargo nivel;

    @Column(name = "DEPARTAMENTO_ID", nullable = false)
    private Long departamentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTAMENTO_ID", insertable = false, updatable = false)
    private Departamento departamento;

    @Column(name = "SALARIO_BASE", precision = 10, scale = 2, nullable = false)
    private BigDecimal salarioBase;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;
}
