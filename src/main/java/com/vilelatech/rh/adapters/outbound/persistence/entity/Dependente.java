package com.vilelatech.rh.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "TB_DEPENDENTE")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
    
    @Column(name = "PARENTESCO", length = 50, nullable = false)
    private String parentesco;
    
    @Column(name = "CPF", length = 14)
    private String cpf;
} 