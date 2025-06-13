package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ColaboradorDtoMapper {

    @Mapping(source = "usuario.nome", target = "nome")
    @Mapping(source = "usuario.email", target = "email")
    ColaboradorResponse toResponse(ColaboradorModel colaboradorModel);
    
    ColaboradorModel toDomain(ColaboradorRequest request);
    
    void updateDomainFromDto(ColaboradorUpdateRequest request, @MappingTarget ColaboradorModel colaboradorModel);
} 