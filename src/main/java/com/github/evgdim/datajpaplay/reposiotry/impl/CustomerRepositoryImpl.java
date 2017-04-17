package com.github.evgdim.datajpaplay.reposiotry.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.evgdim.datajpaplay.reposiotry.CustomerRepositoryCustom;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom{
	private final EntityManager em;
	
	@Autowired
	public CustomerRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public int deleteByCategoryId(long categoryId) {
		Query deleteQuery = em.createQuery("delete from Customer c where c.category.id = :categoryId");
		deleteQuery.setParameter("categoryId", categoryId);
		int delCnt = deleteQuery.executeUpdate();
		return delCnt;
	}

}
