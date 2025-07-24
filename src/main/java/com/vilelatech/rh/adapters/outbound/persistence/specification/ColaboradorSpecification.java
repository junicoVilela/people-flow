package com.vilelatech.rh.adapters.outbound.persistence.specification;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.adapters.outbound.persistence.entity.Cargo;
import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import com.vilelatech.rh.adapters.outbound.persistence.entity.Usuario;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorSpecification {

    public static Specification<Colaborador> withFilters(ColaboradorFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Colaborador, Usuario> usuarioJoin = root.join("usuario");
            
            Join<Colaborador, Cargo> cargoJoin = null;
            Join<Colaborador, Departamento> departamentoJoin = null;

            if (StringUtils.hasText(filter.getNome())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(usuarioJoin.get("nome")), "%" + filter.getNome().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getCargo())) {
                cargoJoin = root.join("cargo");
                predicates.add(criteriaBuilder
                        .like(criteriaBuilder
                                .lower(cargoJoin.get("nome")), "%" + filter.getCargo().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getDepartamento())) {
                departamentoJoin = root.join("departamento");
                predicates.add(criteriaBuilder
                        .like( criteriaBuilder
                                .lower(departamentoJoin.get("nome")), "%" + filter.getDepartamento().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getStatus())) {
                predicates.add(
                        criteriaBuilder.equal( root.get("status"), filter.getStatus()
                ));
            }

            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}