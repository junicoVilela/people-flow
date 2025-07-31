package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoJpaRepository extends JpaRepository<Departamento, Long>, JpaSpecificationExecutor<Departamento> {
    boolean existsByNome(String nome);
    
    boolean existsByNomeAndIdNot(String nome, Long id);

    @Query("SELECT COUNT(d) FROM Departamento d WHERE d.ativo = :ativo")
    int quantidadePorStatus(@Param("ativo") Boolean ativo);
} 