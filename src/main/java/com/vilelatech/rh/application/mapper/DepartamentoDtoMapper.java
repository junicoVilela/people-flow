package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.application.dto.departamento.DepartamentoRequest;
import com.vilelatech.rh.application.dto.departamento.DepartamentoResponse;
import com.vilelatech.rh.application.dto.departamento.DepartamentoUpdateRequest;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface DepartamentoDtoMapper {

    @Mapping(target = "id", ignore = true)
    DepartamentoModel requestToModel(DepartamentoRequest request);

    DepartamentoResponse modelToResponse(DepartamentoModel model);

    List<DepartamentoResponse> modelsToResponses(List<DepartamentoModel> models);

    @Mapping(target = "id", ignore = true)
    void updateModelFromRequest(DepartamentoUpdateRequest request, @MappingTarget DepartamentoModel model);
} 