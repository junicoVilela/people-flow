package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.adapters.outbound.persistence.repository.CargoJpaRepository;
import com.vilelatech.rh.adapters.outbound.persistence.repository.DepartamentoJpaRepository;
import com.vilelatech.rh.application.mapper.CargoMapper;
import com.vilelatech.rh.application.mapper.DepartamentoMapper;
import com.vilelatech.rh.domain.model.CargoModel;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import com.vilelatech.rh.domain.model.RegistroPontoModel;
import com.vilelatech.rh.ports.CargoRepository;
import com.vilelatech.rh.ports.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CargoRepositoryAdapter implements CargoRepository {
    
    private final CargoJpaRepository cargoJpaRepository;
    private final CargoMapper cargoMapper;


    @Override
    public CargoModel save(CargoModel cargoModel) {
        return null;
    }

    @Override
    public Optional<DepartamentoModel> findById(Long id) {
        return Optional.empty();
    }
}