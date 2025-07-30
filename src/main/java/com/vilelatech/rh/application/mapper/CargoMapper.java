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

    @Mapping(source = "departamento.nome", target = "departamentoNome")
    CargoModel toDomain(Cargo cargo);

    Cargo toEntity(CargoModel cargoModel);

    List<CargoModel> toDomainList(List<Cargo> cargos);

} 