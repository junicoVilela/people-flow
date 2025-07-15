package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Cargo;
import com.vilelatech.rh.domain.model.CargoModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CargoMapper {

    @Mapping(source = "departamento.nome", target = "departamento.nome")
    @Mapping(source = "departamento.id", target = "departamento.id")
    CargoModel entityToModel(Cargo cargo);

    @Mapping(target = "departamento", ignore = true)
    Cargo modelToEntity(CargoModel cargoModel);

    List<CargoModel> entitiesToModels(List<Cargo> cargos);

    @AfterMapping
    default void afterEntityToModel(Cargo cargo, @MappingTarget CargoModel cargoModel) {
        if (cargo.getDepartamento() != null) {
            cargoModel.setDepartamento(
                com.vilelatech.rh.domain.model.DepartamentoModel.builder()
                    .id(cargo.getDepartamento().getId())
                    .nome(cargo.getDepartamento().getNome())
                    .build()
            );
        }
    }
} 