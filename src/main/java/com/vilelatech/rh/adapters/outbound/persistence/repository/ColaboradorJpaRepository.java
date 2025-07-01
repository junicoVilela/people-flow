package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.domain.model.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorJpaRepository extends JpaRepository<Colaborador, Long> {
    
    Optional<Colaborador> findByUsuarioId(Long usuarioId);
    
    List<Colaborador> findByStatus(Status status);
    
    boolean existsByCpf(String cpf);
    
    /**
     * Busca paginada de colaboradores com JOIN FETCH para evitar N+1
     * Carrega os dados do usuário em uma única query
     */
    @Query("SELECT c FROM Colaborador c JOIN FETCH c.usuario u ORDER BY c.id")
    Page<Colaborador> findAllWithUsuario(Pageable pageable);
    
    /**
     * Busca colaborador por ID com JOIN FETCH
     */
    @Query("SELECT c FROM Colaborador c JOIN FETCH c.usuario u WHERE c.id = :id")
    Optional<Colaborador> findByIdWithUsuario(Long id);
} 