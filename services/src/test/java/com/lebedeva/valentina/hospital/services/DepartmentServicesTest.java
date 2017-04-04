package com.lebedeva.valentina.hospital.services;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.lebedeva.valentina.hospital.datamodel.Department;

public class DepartmentServicesTest extends AbstractTest {

	@Inject
	private IDepartmentService service;

	@Test
	public void createTest() {
		Department department = new Department();
		department.setName("new department from java test");

		service.save(department);

		Integer savedDepartmentId = department.getId();
		Department departmentFromDb = service.get(savedDepartmentId);

		Assert.notNull(departmentFromDb, "Department must be saved");

		// Assert.notNull(departmentFromDb.getCreated(), "created column must
		// not me empty");

		// Assert.isTrue(departmentFromDb.getCreated().equals(book.getCreated()),
		// "created must be eq...");

		// DELETE for sample

		//service.delete(savedDepartmentId);
	}

	/*@Test
	public void createMultipleTest() {

		Department department1 = new Department();
		department1.setName("new department1 from java");

		Department department2 = new Department();
		department2.setName("new department2 from java");

		Department department3 = new Department();
		department3.setName("new department3 from java");

		service.saveMultiple(department1, department2, department3);
	}*/
}
