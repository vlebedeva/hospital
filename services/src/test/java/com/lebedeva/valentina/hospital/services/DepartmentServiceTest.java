package com.lebedeva.valentina.hospital.services;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.lebedeva.valentina.hospital.datamodel.Department;

public class DepartmentServiceTest {

	@Inject
	private IDepartmentService service;

	@Test
	public void createTest() {
		Department department = new Department();
		department.setName("new department from java");

		service.save(department);

		Integer savedDepartmentId = department.getId();
		Department departmentFromDb = service.getById(savedDepartmentId);

		Assert.notNull(departmentFromDb, "book must be saved");

		// DELETE for sample

		// service.delete(departmentFromDb.getId());
	}

}
