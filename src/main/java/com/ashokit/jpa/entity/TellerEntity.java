package com.ashokit.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TELLER")
public class TellerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TELLER_ID")
	private Integer tellerId;
	
	@Column(length=25)
	private String loginName;
	
	@Column(length=25)
	private String password;
}
