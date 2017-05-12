package com.lebedeva.valentina.hospital.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorkerWithDepartment;

public final class MedicalWorkerWithDepartmentMapper implements RowMapper<MedicalWorkerWithDepartment> {

	@Override
	public MedicalWorkerWithDepartment mapRow(ResultSet rs, int rowNum) throws SQLException {
		MedicalWorker medicalWorker = new MedicalWorker();
		//medicalWorker.setId(rs.getInt("id"));
		medicalWorker.setFullName(rs.getString("full_name"));
		medicalWorker.setSpecialization(rs.getString("specialization"));
		medicalWorker.setCategory(Category.valueOf(rs.getString("category")));

		Department department = new Department();
		//department.setId(rs.getInt("id"));
		department.setName(rs.getString("name"));

		MedicalWorkerWithDepartment medicalWorkerWithDepartment = new MedicalWorkerWithDepartment();
		medicalWorkerWithDepartment.setMedicalWorker(medicalWorker);
		medicalWorkerWithDepartment.setDepartment(department);
		return medicalWorkerWithDepartment;

	}

}
