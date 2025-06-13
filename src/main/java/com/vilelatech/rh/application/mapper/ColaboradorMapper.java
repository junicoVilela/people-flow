package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UsuarioMapper.class})
public interface ColaboradorMapper {

    @Mapping(target = "usuario", ignore = true)
    ColaboradorModel toDomain(Colaborador entity);

    Colaborador toEntity(ColaboradorModel domain);
} 