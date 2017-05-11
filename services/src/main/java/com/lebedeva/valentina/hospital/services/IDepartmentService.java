package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Department;

public interface IDepartmentService {
	Department getById(Integer id);

	List<Department> getAll();

	@Transactional
	void save(Department department);
	
	@Transactional
	void delete(Integer id);
}
