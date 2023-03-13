package com.ashokit.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ashokit.jpa.dao.TellerDAO;
import com.ashokit.jpa.entity.TellerEntity;

@Repository(value = "tellerDAO")
@Transactional
public class TellerDAOImpl implements TellerDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void saveEntity(TellerEntity entity) {

		try {
			entityManager.persist(entity);
			System.out.println("TellerEntity with Id : " + entity.getTellerId() + " is added to Database");

		} catch (Exception e) {
			System.out.println("TellerEntity with Id : " + entity.getTellerId() + " already exists in Database");
		}
	}

	@Override
	public void updateEntity(TellerEntity entity) {
		try {
			entityManager.merge(entity);
			System.out.println("TellerEntity with Id : " + entity.getTellerId() + " is updated to Database");

		} catch (Exception e) {
			System.out.println("TellerEntity with Id : " + entity.getTellerId() + " doesn't exists in Database");
		}

	}

	@Override
	public void deleteEntity(Integer tellerId) {
		try {
			// EntityTransaction t = entityManager.getTransaction();
			Query query = entityManager.createQuery("delete from TellerEntity te where te.tellerId=?1");
			query.setParameter(1, tellerId);
			int i = query.executeUpdate();
			// t.commit();
			if (i == 1) {
				System.out.println("TellerEntity with Id : " + tellerId + " is deleted from Database");
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("TellerEntity with Id : " + tellerId + " doesn't exists in Database");
		}

	}

	@Override
	public TellerEntity findTellerById(Integer tellerId) {
		return entityManager.find(TellerEntity.class, tellerId);
	}

}
