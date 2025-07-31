package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoJpaRepository extends JpaRepository<Cargo, Long>, JpaSpecificationExecutor<Cargo> {

    boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Long id);
    
    int countByDepartamentoId(Long departamentoId);

    @Query("SELECT COUNT(c) FROM Cargo c WHERE c.ativo = :ativo")
    int quantidadePorStatus(@Param("ativo") Boolean ativo);
} 