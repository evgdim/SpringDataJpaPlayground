package com.github.evgdim.datajpaplay.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue("BUSINESS")
@Data
public class BusinessProject extends Project{
	private String businessArea;
}
