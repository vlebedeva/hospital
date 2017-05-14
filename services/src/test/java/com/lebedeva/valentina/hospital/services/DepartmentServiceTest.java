package com.lebedeva.valentina.hospital.services;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.lebedeva.valentina.hospital.datamodel.Department;

public class DepartmentServiceTest extends AbstractTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceTest.class);

	private Department department;
	private Integer savedDepartmentId;
	private String name = "department from test";

	@Inject
	private IDepartmentService service;

	@Before
	public void createTestObject() {
		department = new Department();
		department.setName(name);
	}

	// CREATE
	@Test
	public void createDepartmentTest() {
		LOGGER.info("---------Create Department Test---------");
		service.save(department);
		LOGGER.info("---------Saved New Department ---------");
		Integer savedDepartmentId = department.getId();
		Department departmentFromDB = service.getById(savedDepartmentId);
		Assert.notNull(departmentFromDB, "department must be saved");
		LOGGER.info("---------Delete New Department ---------");
		service.delete(savedDepartmentId);
	}

	// READ
	@Test
	public void readDepartmentTest() {
		LOGGER.info("---------Read Department Test---------");
		service.save(department);
		LOGGER.info("---------Saved New Department ---------");
		savedDepartmentId = department.getId();
		Department departmentFromDB = service.getById(savedDepartmentId);
		Assert.notNull(departmentFromDB, "Department must be saved");
		Assert.isTrue(service.getById(savedDepartmentId).getId().equals(departmentFromDB.getId()),
				"Can't read created Department");
		LOGGER.info("Department with id {} was succesfully read", departmentFromDB.getId());

	}

	// READ ALL
	@Test
	public void readAllDepartmentTest() {
		LOGGER.info("---------Read All Department Test---------");
		service.save(department);
		Integer size = 0;
		Assert.notNull(size = service.getAll().size(), "Can't get list of Department from DB");
		LOGGER.info("Size of Department is {} ", size);
		department.setId(null);
		department.setName("add from readAll test");
		service.save(department);
		Assert.isTrue(size + 1 == service.getAll().size(), "Can't get list of Department from DB");
		LOGGER.info("Size of Department is {} ", size + 1);
	}

	// UPDATE
	@Test
	public void updateAllDepartmentTest() {
		LOGGER.info("---------Update Department Test---------");
		name = "Test Name";
		department.setName(name);
		service.save(department);
		Assert.notNull(department, "Object must be saved");
		LOGGER.info("Saved Department id = {} ", department.getId());
		savedDepartmentId = department.getId();
		name = "Test Update Name";
		department.setName(name);
		service.save(department);
		Assert.isTrue(service.getById(savedDepartmentId).getName().equals(name), "Can't update Department ");
	}

}
