package com.vilelatech.rh.adapters.outbound.persistence.entity;

import com.vilelatech.rh.domain.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_USUARIO")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends BaseEntity {
    
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
} 