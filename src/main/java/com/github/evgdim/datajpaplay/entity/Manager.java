package com.github.evgdim.datajpaplay.entity;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.github.evgdim.datajpaplay.entity.convertor.CommaSeparatedStringConverter;

import lombok.Data;

@Entity
@Data
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@Convert(converter=CommaSeparatedStringConverter.class)
	private List<String> regions; 
}
