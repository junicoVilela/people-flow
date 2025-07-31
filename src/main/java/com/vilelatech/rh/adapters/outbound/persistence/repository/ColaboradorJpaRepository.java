package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorJpaRepository extends JpaRepository<Colaborador, Long>, JpaSpecificationExecutor<Colaborador> {
    boolean existsByCpf(String cpf);
    
    @Query("SELECT COUNT(c) FROM Colaborador c WHERE c.status = :status")
    Long quantidadePorStatus(@Param("status") StatusColaborador status);
} 