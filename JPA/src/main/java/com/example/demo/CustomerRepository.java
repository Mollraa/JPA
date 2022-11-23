package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//mybatis는 자동으로 리포지토리 등록해줘서 안해준거였음.
@Repository
public interface CustomerRepository extends JpaRepository<Customer,	Long> {

}
