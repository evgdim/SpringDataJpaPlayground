package com.github.evgdim.datajpaplay.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("IT")
public class ItProject extends Project{
	private String itArea;
}
