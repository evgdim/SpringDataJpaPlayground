package com.github.evgdim.datajpaplay.entity.embeddables;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PersonalIdInfo {
	private String number;
	private LocalDate issuedOn;
}
