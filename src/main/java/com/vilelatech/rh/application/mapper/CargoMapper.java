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
    @Mapping(source = "departamentoId", target = "departamentoId")
    CargoModel entityToModel(Cargo cargo);

    @Mapping(target = "departamento", ignore = true)
    Cargo modelToEntity(CargoModel cargoModel);

    List<CargoModel> entitiesToModels(List<Cargo> cargos);

} 