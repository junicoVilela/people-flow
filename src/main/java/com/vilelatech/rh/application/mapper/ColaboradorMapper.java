package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import org.mapstruct.Mapper;

@Mapper(uses = {UsuarioMapper.class, CargoMapper.class, DepartamentoMapper.class})
public interface ColaboradorMapper {

    ColaboradorModel toDomain(Colaborador entity);

    Colaborador toEntity(ColaboradorModel domain);
} 