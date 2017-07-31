package com.github.evgdim.datajpaplay.reposiotry;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.github.evgdim.datajpaplay.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomerRepositoryCustom, JpaSpecificationExecutor {
    List<Customer> findByLastName(String lastName);
    @Transactional
    @Modifying
    @Query("update Customer c set c.firstName = ?1 where c.id = ?2")
    int updateNameById(String nameToUpdate, long id);
    @Transactional
    @Modifying
    @Query("update Customer c set c.firstName = ?1 where c.id in (?2)")
    int updateNameByIds(String nameToUpdate, List<Long> ids);
}
