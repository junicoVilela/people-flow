package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.ColaboradorEntity;
import com.vilelatech.rh.domain.model.Colaborador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UsuarioMapper.class})
public interface ColaboradorMapper {

    @Mapping(target = "usuario", ignore = true)
    Colaborador toDomain(ColaboradorEntity entity);

    ColaboradorEntity toEntity(Colaborador domain);
} 