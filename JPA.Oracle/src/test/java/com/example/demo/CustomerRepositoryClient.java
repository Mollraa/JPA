package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
public class CustomerRepositoryClient {

	@Autowired
	CustomerRepository repo;
	
	//@Test
	public void findName() {
		List<Customer> list = repo.findByName("백진희");
		System.out.println(list);
		assertEquals(list.get(0).getName(), "백진희");
	}
	
	@Test
	public void find() {
		Optional<Customer> cust = repo.findById(1L);
		System.out.println(cust);
		assertEquals(cust.get().getName(), "백진희");
	}
	
	
	
	
	//@Test
	@Commit
	public void insert() {
		//Customer cust = new Customer; 대신 @Builder사용
		Customer cust = Customer.builder().name("백진희").phone("010-9979-5259").build();
		repo.save(cust);
	}
}
