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
    @Mapping(target = "departamento", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "criadoPor", ignore = true)
    @Mapping(target = "atualizadoPor", ignore = true)
    CargoModel requestToModel(CargoRequest request);

    @Mapping(source = "departamento.nome", target = "departamentoNome")
    @Mapping(source = "departamentoId", target = "departamentoId")
    CargoResponse modelToResponse(CargoModel model);

    List<CargoResponse> modelsToResponses(List<CargoModel> models);

    @AfterMapping
    default void afterRequestToModel(CargoRequest request, @MappingTarget CargoModel model) {
        if (model.getAtivo() == null) {
            model.setAtivo(true);
        }
    }

    @AfterMapping
    default void afterModelToResponse(CargoModel model, @MappingTarget CargoResponse response) {
        if (model.getDepartamento() != null) {
            response.setDepartamentoNome(model.getDepartamento().getNome());
        }
    }
} 