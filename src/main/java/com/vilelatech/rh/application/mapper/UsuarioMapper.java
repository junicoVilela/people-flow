package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Usuario;
import com.vilelatech.rh.domain.model.UsuarioModel;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    
    UsuarioModel toDomain(Usuario entity);
    
    Usuario toEntity(UsuarioModel domain);
} 