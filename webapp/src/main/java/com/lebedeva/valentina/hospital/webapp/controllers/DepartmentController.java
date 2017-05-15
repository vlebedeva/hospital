package com.lebedeva.valentina.hospital.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.services.IDepartmentService;
import com.lebedeva.valentina.hospital.webapp.models.DepartmentModel;
import com.lebedeva.valentina.hospital.webapp.models.IdModel;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Inject
	private IDepartmentService departmentService;

	private List<Department> all = new ArrayList<>();

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Department> allDepartments;
		allDepartments = departmentService.getAll();
		all.addAll(allDepartments);
		List<DepartmentModel> convertedDepartments = new ArrayList<>();
		for (Department department : allDepartments) {
			convertedDepartments.add(entity2model(department));
		}
		LOGGER.info("get all departments");
		return new ResponseEntity<List<DepartmentModel>>(convertedDepartments, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "id") Integer departmentIdParam) {
		Department department = departmentService.getById(departmentIdParam);
		DepartmentModel departmentModel = entity2model(department);
		return new ResponseEntity<DepartmentModel>(departmentModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentModel departmentModel) {
		Department department = model2entity(departmentModel);
		departmentService.save(department);
		return new ResponseEntity<IdModel>(new IdModel(department.getId()), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDepartment(@PathVariable(value = "id") Integer departmentIdParam,
			@RequestBody DepartmentModel departmentModel) {
		Department department = departmentService.getById(departmentIdParam);
		department.setName(departmentModel.getName());
		departmentService.save(department);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDepartment(@PathVariable(value = "id") Integer departmentIdParam) {
		departmentService.delete(departmentIdParam);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}

	private DepartmentModel entity2model(Department department) {
		DepartmentModel departmentModel = new DepartmentModel();
		departmentModel.setName(department.getName());
		return departmentModel;
	}

	private Department model2entity(DepartmentModel departmentModel) {
		Department department = new Department();
		department.setName(departmentModel.getName());
		return department;
	}

}
