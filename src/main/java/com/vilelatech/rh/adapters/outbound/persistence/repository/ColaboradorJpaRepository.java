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
    List<Colaborador> findByStatus(StatusColaborador status);
    
    boolean existsByCpf(String cpf);

    @Query("SELECT c FROM Colaborador c JOIN FETCH c.usuario u WHERE c.id = :id")
    Optional<Colaborador> findByIdWithUsuario(Long id);
} 