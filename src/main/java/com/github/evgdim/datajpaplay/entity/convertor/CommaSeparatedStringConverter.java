package com.github.evgdim.datajpaplay.entity.convertor;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import javax.persistence.AttributeConverter;

public class CommaSeparatedStringConverter implements AttributeConverter<List<String>, String> {
	private static final String SEPARATOR = ",";

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		StringJoiner sj = new StringJoiner(SEPARATOR);
		attribute.forEach(s -> sj.add(s));
		return sj.toString();
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		String[] split = dbData.split(SEPARATOR);
		return Arrays.asList(split);
	}

}
