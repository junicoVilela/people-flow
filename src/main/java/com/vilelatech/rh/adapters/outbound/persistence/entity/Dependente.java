package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.Parentesco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "TB_DEPENDENTE")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Dependente extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "COLABORADOR_ID", nullable = false)
    private Long colaboradorId;
    
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "PARENTESCO", nullable = false)
    private Parentesco parentesco;
    
    @Column(name = "CPF", length = 14)
    private String cpf;
} 