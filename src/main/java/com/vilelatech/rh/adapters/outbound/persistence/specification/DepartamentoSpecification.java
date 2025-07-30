package com.vilelatech.rh.adapters.outbound.persistence.specification;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Departamento;
import com.vilelatech.rh.application.dto.departamento.DepartamentoFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoSpecification {

    public static Specification<Departamento> withFilters(DepartamentoFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(filter.getNome())) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
} 