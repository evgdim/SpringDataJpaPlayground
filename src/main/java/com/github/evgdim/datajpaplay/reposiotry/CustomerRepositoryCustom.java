package com.github.evgdim.datajpaplay.reposiotry;

public interface CustomerRepositoryCustom {
	int deleteByCategoryId(long categoryId);
	int deleteByCategoryIdSession(long categoryId);
}
