package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USUARIO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "EMAIL", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "SENHA_HASH", length = 255, nullable = false)
    private String senhaHash;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", length = 20, nullable = false)
    private Role role;
    
    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;
    
    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
} 