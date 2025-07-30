package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.application.dto.cargo.CargoRequest;
import com.vilelatech.rh.application.dto.cargo.CargoResponse;
import com.vilelatech.rh.domain.model.CargoModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CargoDtoMapper {

    @Mapping(target = "id", ignore = true)
    CargoModel requestToModel(CargoRequest request);

    @Mapping(source = "departamentoNome", target = "departamentoNome")
    CargoResponse modelToResponse(CargoModel model);

    List<CargoResponse> modelsToResponses(List<CargoModel> models);

    @Mapping(target = "id", ignore = true)
    void updateModelFromRequest(CargoRequest request, @MappingTarget CargoModel model);
} 