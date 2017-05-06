package com.github.evgdim.datajpaplay.reposiotry;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.evgdim.datajpaplay.entity.Manager;

public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long>{

}
