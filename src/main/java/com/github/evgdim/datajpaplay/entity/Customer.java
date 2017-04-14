// tag::sample[]
package com.github.evgdim.datajpaplay.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private CustomerCategory category;

    protected Customer() {}

    public Customer(String firstName, String lastName, CustomerCategory category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }



// end::sample[]

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

