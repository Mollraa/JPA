package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//mybatis는 자동으로 리포지토리 등록해줘서 안해준거였음.
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함
	public List<Customer> findByName(String name);

	public List<Customer> findByPhone(String phone); // like검색도 가능

	public List<Customer> findByNameLike(String keyword);

	@Query("select u from Customer u where u.name like ?1%")
	List<Customer> findByAndSort(String name);

	@Transactional
	@Modifying
	@Query("update Customer u set u.name = ?1 where u.id = ?2")
	int setFixedNameFor(String name, Long id);
}
