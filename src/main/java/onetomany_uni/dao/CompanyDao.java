package onetomany_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_uni.dto.Company;
import onetomany_uni.dto.Employee;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sujit").createEntityManager();
	}

	public void saveCompany(Company company) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<Employee> list = company.getList();
		transaction.begin();
		for (Employee employee : list) {
			manager.persist(employee);
		}
		manager.persist(company);
		transaction.commit();
	}

	public void getCompany(int id) {
		
		Company company = getEntityManager().find(Company.class, id);
		if(company!=null)
		{
			System.out.println(company);
		}else{
			System.out.println("No Company find with id : "+id);
		}
	}
	
	public void deleteCompany(int id) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Company company = manager.find(Company.class, id);
		if (company!=null) {
			List<Employee> list = company.getList();
			transaction.begin();
			for (Employee employee : list) {
				manager.remove(employee);
			}
			manager.remove(company);
			transaction.commit();
		} else {
            System.out.println("No Company found with the id : "+id);
		}
	}
	
	public void updateCompany(int id, Company company) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Company company2 = manager.find(Company.class, id);
		if (company2!=null) {
			company.setId(id);
			company.setList(company2.getList());
			transaction.begin();
			manager.merge(company);
			transaction.commit();
		} else {
            System.out.println("No Company found with id : "+id);
		}
		
	}
	
	public void updateBoth(int id, Company company) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Company company2 = manager.find(Company.class, id);
		if (company2!=null) {
			company.setId(id);
			for (int i = 0; i < company2.getList().size(); i++) {
				company.getList().get(i).setId(company2.getList().get(i).getId());
			}
			
			transaction.begin();
			for (Employee employee : company.getList()) {
				manager.merge(employee);
			}
			manager.merge(company);
			transaction.commit();
		}else {
			System.out.println("No company found with id : "+id);
		}
	}
}
