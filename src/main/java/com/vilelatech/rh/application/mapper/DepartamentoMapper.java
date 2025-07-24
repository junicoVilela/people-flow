package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartamentoMapper {

    DepartamentoModel toDomain(Departamento departamento);
    
    Departamento toEntity(DepartamentoModel departamentoModel);
} 