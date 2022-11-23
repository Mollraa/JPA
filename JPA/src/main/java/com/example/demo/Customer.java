package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;


//javax로 어노테이션 다넣어주기 

@Data
@Entity
public class Customer	{
				@Id
@GeneratedValue(strategy	=	GenerationType.AUTO)
				private Long	id;
				@Column(length	=	20,	nullable	=	false)
				private String	name;
				@Column(length	=	20,	nullable	=	false,	unique	=	true)
				private String	phone;					
}