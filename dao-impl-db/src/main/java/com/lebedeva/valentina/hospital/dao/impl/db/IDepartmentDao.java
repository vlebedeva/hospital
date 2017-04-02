package com.lebedeva.valentina.hospital.dao.impl.db;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Department;

public interface IDepartmentDao {

	Department get(Integer id);
	
	List<Department> getAll();

	Department insert(Department department);

	void update(Department department);
	
    void delete(Integer id);

}
