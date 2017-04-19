package com.github.evgdim.datajpaplay;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.evgdim.datajpaplay.entity.Customer;
import com.github.evgdim.datajpaplay.entity.CustomerCategory;
import com.github.evgdim.datajpaplay.reposiotry.CustomerCategoryRepository;
import com.github.evgdim.datajpaplay.reposiotry.CustomerRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepo, CustomerCategoryRepository categoryRepo) {
		return (args) -> {
			CustomerCategory customerCategory = categoryRepo.save(new CustomerCategory("standart"));
			//CustomerCategory findOne = categoryRepo.findOne(1L);
			Customer cust = new Customer("evgeni", "Dimitrov", customerCategory);
			
			customerRepo.save(cust);
			
			customerRepo.updateNameByIds("newName", Arrays.asList(cust.getId()));
			
			customerRepo.findAll().forEach(c -> log.info(c.toString()));
			
			customerRepo.deleteByCategoryIdSession(customerCategory.getId());
			
			customerRepo.findAll().forEach(c -> log.info(c.toString()));
		};
	}

}
