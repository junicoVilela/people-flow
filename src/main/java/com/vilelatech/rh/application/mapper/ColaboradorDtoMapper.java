package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ColaboradorDtoMapper {

    @Mapping(source = "usuario.nome", target = "nome")
    @Mapping(source = "usuario.email", target = "email")
    @Mapping(source = "cargo.nome", target = "cargo")
    @Mapping(source = "departamento.nome", target = "departamento")
    public abstract ColaboradorResponse toResponse(ColaboradorModel colaboradorModel);

    public abstract ColaboradorModel toDomain(ColaboradorRequest request);

    @Mapping(target = "usuario.nome", source = "nome")
    public abstract void updateColaborador(ColaboradorUpdateRequest request, @MappingTarget ColaboradorModel colaboradorModel);

    @Mapping(target = "id", ignore = true)
    public abstract UsuarioModel toUsuarioModel(ColaboradorRequest request);
} 