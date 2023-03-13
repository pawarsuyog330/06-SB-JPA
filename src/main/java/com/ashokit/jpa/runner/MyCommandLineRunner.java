package com.ashokit.jpa.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.jpa.dao.TellerDAO;
import com.ashokit.jpa.entity.TellerEntity;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	TellerDAO dao;

	@Override
	public void run(String... args) throws Exception {
		/*
		TellerEntity entity = new TellerEntity();
		entity.setLoginName("Suyog");
		entity.setPassword("Swami@123");
		dao.saveEntity(entity);

		TellerEntity entity = new TellerEntity();
		entity.setTellerId(2);
		entity.setLoginName("Suyog");
		entity.setPassword("Rajput@123");
		 dao.updateEntity(entity);
		  
		 
		 dao.deleteEntity(2);
*/		 
	  TellerEntity entity =dao.findTellerById(1);
		 System.out.println(entity.getLoginName()+" "+entity.getPassword());
	}

}
