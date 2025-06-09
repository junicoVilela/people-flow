package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.RegistroPontoEntity;
import com.vilelatech.rh.domain.model.RegistroPonto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {ColaboradorMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegistroPontoMapper {

    RegistroPonto toDomain(RegistroPontoEntity entity);

    RegistroPontoEntity toEntity(RegistroPonto domain);
} 