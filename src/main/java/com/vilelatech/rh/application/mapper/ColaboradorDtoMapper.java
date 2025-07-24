package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.UsuarioModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ColaboradorDtoMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(source = "usuario.nome", target = "nome")
    @Mapping(source = "usuario.email", target = "email")
    @Mapping(source = "cargo.nome", target = "cargo")
    @Mapping(source = "departamento.nome", target = "departamento")
    @Mapping(source = "cargoId", target = "cargoId")
    @Mapping(source = "departamentoId", target = "departamentoId")
    public abstract ColaboradorResponse toResponse(ColaboradorModel colaboradorModel);

    @AfterMapping
    protected void afterToResponse(ColaboradorModel colaboradorModel, @MappingTarget ColaboradorResponse response) {
        response.setCargo(mapCargoNome(colaboradorModel));
        response.setDepartamento(mapDepartamentoNome(colaboradorModel));
    }

    protected String mapCargoNome(ColaboradorModel colaboradorModel) {
        return colaboradorModel.getCargo() != null ? colaboradorModel.getCargo().getNome() : "";
    }

    protected String mapDepartamentoNome(ColaboradorModel colaboradorModel) {
        return colaboradorModel.getDepartamento() != null ? colaboradorModel.getDepartamento().getNome() : "";
    }

    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(source = "cargoId", target = "cargoId")
    @Mapping(source = "departamentoId", target = "departamentoId")
    public abstract ColaboradorModel toDomain(ColaboradorRequest request);
    
    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "usuario.nome", source = "nome")
    @Mapping(target = "usuario.dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(source = "cargoId", target = "cargoId")
    @Mapping(source = "departamentoId", target = "departamentoId")
    public abstract void updateColaborador(ColaboradorUpdateRequest request, @MappingTarget ColaboradorModel colaboradorModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senhaHash", expression = "java(passwordEncoder.encode(request.getSenha()))")
    @Mapping(target = "role", constant = "COLABORADOR")
    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    public abstract UsuarioModel toUsuarioModel(ColaboradorRequest request);
    

} 