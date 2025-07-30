package com.vilelatech.rh.adapters.outbound.persistence.specification;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Cargo;
import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import com.vilelatech.rh.application.dto.cargo.CargoFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CargoSpecification {

    public static Specification<Cargo> withFilters(CargoFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Cargo, Departamento> departamentoJoin = root.join("departamento");

            if (StringUtils.hasText(filter.getNome())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getDepartamento())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(departamentoJoin.get("nome")), "%" + filter.getDepartamento().toLowerCase() + "%"
                ));
            }

            if (StringUtils.hasText(filter.getStatus())) {
                boolean ativo = "ATIVO".equalsIgnoreCase(filter.getStatus());
                predicates.add(criteriaBuilder.equal(root.get("ativo"), ativo));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
} 