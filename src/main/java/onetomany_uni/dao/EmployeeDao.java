package onetomany_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sujit").createEntityManager();
	}
	
	
}
