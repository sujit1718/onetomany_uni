package onetomany_uni.controller;

import java.util.ArrayList;

import java.util.List;
import onetomany_uni.dao.CompanyDao;
import onetomany_uni.dto.Company;
import onetomany_uni.dto.Employee;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setId(4);
		e1.setName("Raju");
		e1.setPhone(12345678);
		e1.setAddress("Latur");
		
		Employee e2 = new Employee();
		e2.setId(5);
		e2.setName("Sham");
		e2.setPhone(234654567);
		e2.setAddress("Bengluru");
		
		Employee e3 = new Employee();
		e3.setId(6);
		e3.setName("Omkar");
		e3.setPhone(9876544);
		e3.setAddress("Nilanga");
		
		List<Employee> list = new ArrayList<Employee> ();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Company company = new Company();
		company.setId(102);
		company.setName("Epam");
		company.setLocation("Hydrabad");
		company.setList(list);
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sujit");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		transaction.begin();
//		manager.persist(e1);
//		manager.persist(e2);
//		manager.persist(e3);
//		manager.persist(company);
//		transaction.commit();
		
		CompanyDao dao = new CompanyDao();
		//dao.saveCompany(company);
		//dao.getCompany(101);
		//dao.deleteCompany(102);
		//dao.updateCompany(101, company);
		dao.updateBoth(101, company);
	}
}
