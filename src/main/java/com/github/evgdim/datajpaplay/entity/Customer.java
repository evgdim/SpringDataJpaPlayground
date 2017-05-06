package com.github.evgdim.datajpaplay.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.evgdim.datajpaplay.entity.embeddables.PersonalIdInfo;
import com.github.evgdim.datajpaplay.entity.enums.CustomerEntityType;

import lombok.Data;

@Entity
@Table(indexes = {
		@Index( columnList="category_id", name="ix_cust_category" ),
		@Index( columnList="firstName", name="ix_cust_first_name" )
	})
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(length=100, nullable=false)
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name="category_id", foreignKey=@ForeignKey(name="fk_cust_category"))
    private CustomerCategory category;
    @Enumerated(EnumType.STRING)
    private CustomerEntityType entityType;
    @Embedded
    private PersonalIdInfo personalIdInfo;

    protected Customer() {}

    public Customer(String firstName, String lastName, CustomerCategory category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }


}

