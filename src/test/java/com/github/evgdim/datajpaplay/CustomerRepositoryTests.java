package com.github.evgdim.datajpaplay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.evgdim.datajpaplay.entity.Customer;
import com.github.evgdim.datajpaplay.entity.CustomerCategory;
import com.github.evgdim.datajpaplay.reposiotry.CustomerCategoryRepository;
import com.github.evgdim.datajpaplay.reposiotry.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTests {
	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTests.class);
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerCategoryRepository customerCategoryRepository;

    @Test
    public void testFindByLastName() {
        Customer customer = new Customer("evgeni","Dimitrov",null);
        entityManager.persist(customer);

        List<Customer> findByLastName = customerRepository.findByLastName(customer.getLastName());

        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }
    
    @Test
    public void testDeleteById() {
    	CustomerCategory customerCategory = customerCategoryRepository.save(new CustomerCategory("standart"));
		Customer cust = new Customer("evgeni", "Dimitrov", customerCategory);
		customerRepository.save(cust);
		assertEquals(1L, customerRepository.findAll().spliterator().getExactSizeIfKnown());
		customerRepository.deleteByCategoryIdSession(customerCategory.getId());
		assertEquals(0L, customerRepository.findAll().spliterator().getExactSizeIfKnown());
    }
    
    @Test
    public void updateNameByIdsTest() {
    	CustomerCategory customerCategory = customerCategoryRepository.save(new CustomerCategory("standart"));
    	Customer cust = new Customer("evgeni", "Dimitrov", customerCategory);
		customerRepository.save(cust);
    	customerRepository.updateNameByIds("newName", Arrays.asList(cust.getId()));
    	entityManager.refresh(cust);
    	assertEquals("updated name matches", "newName", cust.getFirstName());
    }
}