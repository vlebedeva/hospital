package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.impl.db.IDepartmentDao;
import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.services.IDepartmentServices;

@Service
public class DepartmentServicesImpl implements IDepartmentServices {

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
			departmentDao.update(department);
		}
	}

	@Override
	public void delete(Integer id) {
		departmentDao.delete(id);

	}

	@Override
	public void saveMultiple(Department... departmentAray) {

		for (Department department : departmentAray) {
			save(department);
		}

	}

}
