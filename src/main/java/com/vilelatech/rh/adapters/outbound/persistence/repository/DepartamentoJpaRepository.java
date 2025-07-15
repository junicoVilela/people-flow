package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoJpaRepository extends JpaRepository<Departamento, Long> {
    
    List<Departamento> findByAtivoTrue();
    
    boolean existsByNomeAndAtivoTrue(String nome);
    
    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);
} 