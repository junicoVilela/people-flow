package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.UsuarioEntity;
import com.vilelatech.rh.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    
    Usuario toDomain(UsuarioEntity entity);
    
    UsuarioEntity toEntity(Usuario domain);
} 