package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IDepartmentDao;
import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.services.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Inject
	private IDepartmentDao departmentDao;

	@Override
	public Department get(Integer id) {
		return departmentDao.get(id);
	}

	@Override
	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	@Override
	public void save(Department department) {
		if (department.getId() == null) {
			System.out.println("Insert new Department");
			departmentDao.insert(department);
		} else {
			
			System.out.println("Update Department");
			departmentDao.update(department);
		}
	}

	@Override
	public void delete(Integer id) {
		departmentDao.delete(id);

	}

	@Override
	public void saveMultiple(Department... departmentArray) {

		for (Department department : departmentArray) {
			save(department);
		}

	}

}
