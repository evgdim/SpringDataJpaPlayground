package com.github.evgdim.datajpaplay.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CustomerCategory {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	public CustomerCategory() {	}
	public CustomerCategory(String name) {
		this.name = name;
	}

}
