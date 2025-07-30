package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoJpaRepository extends JpaRepository<Departamento, Long>, JpaSpecificationExecutor<Departamento> {
    
    List<Departamento> findByAtivoTrue();
    
    boolean existsByNomeAndAtivoTrue(String nome);
    
    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);

    @Query("SELECT COUNT(d) FROM Departamento d WHERE d.ativo = :ativo")
    int countByStatus(@Param("ativo") Boolean ativo);
} 