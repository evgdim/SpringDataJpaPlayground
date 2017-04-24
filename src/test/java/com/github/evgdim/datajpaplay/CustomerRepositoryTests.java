package com.github.evgdim.datajpaplay;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.evgdim.datajpaplay.entity.Customer;
import com.github.evgdim.datajpaplay.reposiotry.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customers;

    @Test
    public void testFindByLastName() {
        Customer customer = new Customer("evgeni","Dimitrov",null);
        entityManager.persist(customer);

        List<Customer> findByLastName = customers.findByLastName(customer.getLastName());

        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }
}