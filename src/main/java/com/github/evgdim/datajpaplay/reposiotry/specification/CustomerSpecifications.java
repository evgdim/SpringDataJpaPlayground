package com.github.evgdim.datajpaplay.reposiotry.specification;

import com.github.evgdim.datajpaplay.entity.Customer;
import com.github.evgdim.datajpaplay.entity.enums.CustomerEntityType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerSpecifications {
    public static Specification<Customer> isLegalEntity() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("entityType"), CustomerEntityType.LEGAL_ENTITY);
    }
}

