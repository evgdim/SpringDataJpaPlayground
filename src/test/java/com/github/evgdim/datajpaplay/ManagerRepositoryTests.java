package com.github.evgdim.datajpaplay;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

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

import com.github.evgdim.datajpaplay.entity.Manager;
import com.github.evgdim.datajpaplay.reposiotry.ManagerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ManagerRepositoryTests {
	private static final Logger log = LoggerFactory.getLogger(ManagerRepositoryTests.class);
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
	private ManagerRepository managerRepository;
	
	@Test
	public void commaSeparatedConverterTest() {
		List<String> testRegions = Arrays.asList("Sofia", "Plovdiv", "Burgas");
		Manager man = new Manager();
		man.setName("ManName");
		man.setRegions(testRegions);
		this.managerRepository.save(man);
		
		Query q = entityManager.getEntityManager().createNativeQuery("select regions from manager where id = "+man.getId());
		String regions = (String) q.getSingleResult();
		log.info("[commaSeparatedConverterTest] native query result: "+regions);
		assertEquals("Regs in db are equa", regions, "Sofia,Plovdiv,Burgas");
		entityManager.detach(man);
		
		Manager manager = managerRepository.findOne(man.getId());
		assertEquals("Regs in entity are equa", manager.getRegions(), testRegions);
	}
}
