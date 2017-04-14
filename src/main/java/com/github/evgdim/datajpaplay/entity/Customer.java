package com.github.evgdim.datajpaplay.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(indexes = {
		@Index( columnList="category_id", name="ix_cust_category" ),
		@Index( columnList="firstName", name="ix_cust_first_name" )
	})
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name="category_id", foreignKey=@ForeignKey(name="fk_cust_category"))
    private CustomerCategory category;

    protected Customer() {}

    public Customer(String firstName, String lastName, CustomerCategory category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", category=" + category
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

