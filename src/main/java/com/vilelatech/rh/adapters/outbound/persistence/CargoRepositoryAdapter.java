package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Cargo;
import com.vilelatech.rh.adapters.outbound.persistence.repository.CargoJpaRepository;
import com.vilelatech.rh.adapters.outbound.persistence.specification.CargoSpecification;
import com.vilelatech.rh.application.dto.cargo.CargoFilter;
import com.vilelatech.rh.application.mapper.CargoMapper;
import com.vilelatech.rh.domain.model.CargoModel;
import com.vilelatech.rh.ports.CargoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CargoRepositoryAdapter implements CargoRepository {
    
    private final CargoJpaRepository cargoJpaRepository;
    private final CargoMapper cargoMapper;

    @Override
    public CargoModel save(CargoModel cargoModel) {
        Cargo cargo = cargoMapper.toEntity(cargoModel);
        Cargo cargoSalvo = cargoJpaRepository.save(cargo);

        return cargoMapper.toDomain(cargoSalvo);
    }

    @Override
    public Optional<CargoModel> findById(Long id) {
        Optional<Cargo> cargo = cargoJpaRepository.findById(id);
        return cargo.map(cargoMapper::toDomain);
    }

    @Override
    public Page<CargoModel> findAll(CargoFilter filter, Pageable pageable) {
        return cargoJpaRepository.findAll(CargoSpecification.withFilters(filter), pageable)
                .map(cargoMapper::toDomain);
    }

    @Override
    public boolean existsByNomeAndAtivoTrue(String nome) {
        return cargoJpaRepository.existsByNomeAndAtivoTrue(nome);
    }

    @Override
    public boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id) {
        return cargoJpaRepository.existsByNomeAndAtivoTrueAndIdNot(nome, id);
    }

    @Override
    public int countByDepartamentoIdAndAtivoTrue(Long departamentoId) {
        return cargoJpaRepository.countByDepartamentoIdAndAtivoTrue(departamentoId);
    }

    @Override
    public int countByDepartamentoId(Long departamentoId) {
        return cargoJpaRepository.countByDepartamentoId(departamentoId);
    }
}