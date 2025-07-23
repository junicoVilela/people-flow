package com.vilelatech.rh.adapters.outbound.persistence.specification;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
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

            Join<Object, Object> usuarioJoin = root.join("usuario");

            if (StringUtils.hasText(filter.getNome())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(usuarioJoin.get("nome")),
                    "%" + filter.getNome().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getCargo())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("cargo")),
                    "%" + filter.getCargo().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getDepartamento())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("departamento")),
                    "%" + filter.getDepartamento().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getStatus())) {
                predicates.add(criteriaBuilder.equal(
                    root.get("status"),
                    filter.getStatus()
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}