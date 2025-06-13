package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.RegistroPonto;
import com.vilelatech.rh.domain.model.RegistroPontoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {ColaboradorMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegistroPontoMapper {

    RegistroPontoModel toDomain(RegistroPonto entity);

    RegistroPonto toEntity(RegistroPontoModel domain);
} 