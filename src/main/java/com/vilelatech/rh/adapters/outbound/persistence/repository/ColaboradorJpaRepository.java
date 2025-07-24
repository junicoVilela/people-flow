package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorJpaRepository extends JpaRepository<Colaborador, Long>, JpaSpecificationExecutor<Colaborador> {
    boolean existsByCpf(String cpf);
    
    @Query("SELECT c FROM Colaborador c JOIN FETCH c.usuario u JOIN FETCH c.cargo car JOIN FETCH c.departamento d WHERE c.id = :id")
    Optional<Colaborador> findByIdWithUsuarioAndCargoAndDepartamento(Long id);

    @Query("SELECT c FROM Colaborador c JOIN FETCH c.usuario u JOIN FETCH c.cargo car JOIN FETCH c.departamento d WHERE c.status = :status")
    List<Colaborador> findByStatusWithUsuarioAndCargoAndDepartamento(StatusColaborador status);
} 