package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoJpaRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findByAtivoTrueOrderByNome();

    boolean existsByNomeAndAtivoTrue(String nome);

    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);
    
    int countByDepartamentoIdAndAtivoTrue(Long departamentoId);
    
    int countByDepartamentoId(Long departamentoId);
} 