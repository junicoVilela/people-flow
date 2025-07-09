package com.vilelatech.rh.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DOCUMENTO_COLABORADOR")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoColaborador extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "COLABORADOR_ID", nullable = false)
    private Long colaboradorId;
    
    @Column(name = "TIPO_DOCUMENTO", length = 50, nullable = false)
    private String tipoDocumento;
    
    @Column(name = "DESCRICAO", columnDefinition = "TEXT")
    private String descricao;
    
    @Column(name = "CAMINHO_ARQUIVO", columnDefinition = "TEXT", nullable = false)
    private String caminhoArquivo;
    
    @Column(name = "DATA_UPLOAD", nullable = false)
    private LocalDateTime dataUpload;
} 