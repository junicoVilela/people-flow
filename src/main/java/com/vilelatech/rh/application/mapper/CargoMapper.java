package com.vilelatech.rh.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = {CargoMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoMapper {

} 