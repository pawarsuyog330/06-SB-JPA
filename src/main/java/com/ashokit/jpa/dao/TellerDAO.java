package com.ashokit.jpa.dao;

import com.ashokit.jpa.entity.TellerEntity;

public interface TellerDAO {
	
	void saveEntity(TellerEntity entity);
	
	void updateEntity(TellerEntity entity);
	
	void deleteEntity(Integer tellerId);
	
	TellerEntity findTellerById(Integer tellerId);

}
