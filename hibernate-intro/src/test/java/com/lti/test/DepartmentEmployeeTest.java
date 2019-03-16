package com.lti.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Department;
import com.lti.entity.Employee;
import com.lti.entity.Song;

public class DepartmentEmployeeTest {

	
	@Test
	public void addNewDepartment() { 
		Department dept = new Department();
		dept.setName("Hungama");
		dept.setLocation("TV");
		GenericDao dao = new GenericDao();
		dao.merge(dept);
	}

	@Test
	public void addEmployeesToExistingDepartment() {
		GenericDao dao = new GenericDao();
	Department  dept = dao.fetch(Department.class, 161);// check album id in db
		Employee e1 = new Employee();
		e1.setName("Shinchan");
		e1.setSalary(245.26);
		e1.setDept(dept);

		Employee e2 = new Employee();
		e2.setName("Hero");
		e2.setSalary(67.68);
		e2.setDept(dept);

		Employee e3 = new Employee();
		e3.setName("Hagemaroo");
		e3.setSalary(2025.68);
		e3.setDept(dept);

		dao.merge(dept);
		dao.merge(e1);
		dao.merge(e2);
		dao.merge(e3);

	}


	


}
