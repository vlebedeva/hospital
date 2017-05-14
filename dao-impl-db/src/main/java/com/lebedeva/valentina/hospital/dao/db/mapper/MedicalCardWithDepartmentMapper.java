package com.lebedeva.valentina.hospital.dao.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.datamodel.Diagnosis;
import com.lebedeva.valentina.hospital.datamodel.MedicalCard;
import com.lebedeva.valentina.hospital.datamodel.MedicalCardWithDepartment;

public final class MedicalCardWithDepartmentMapper implements RowMapper<MedicalCardWithDepartment> {

	@Override
	public MedicalCardWithDepartment mapRow(ResultSet rs, int rowNum) throws SQLException {
		MedicalCard medicalCard = new MedicalCard();
		medicalCard.setId(rs.getInt("id"));
		medicalCard.setPatientFullName(rs.getString("patient_full_name"));
		medicalCard.setBirthday(rs.getDate("birthday"));
		medicalCard.setEnterDate(rs.getDate("enter_date"));
		

		Department department = new Department();
		//department.setId(rs.getInt("id"));
		department.setName(rs.getString("name_department"));
		
		Diagnosis diagnosis = new Diagnosis();
		//diagnosis.setId(rs.getInt("id"));
		diagnosis.setName(rs.getString("name_diagnosis"));
		

		MedicalCardWithDepartment medicalCardWithDepartment = new MedicalCardWithDepartment();
		medicalCardWithDepartment.setMedicalCard(medicalCard);
		medicalCardWithDepartment.setDepartment(department);
		medicalCardWithDepartment.setDiagnosis(diagnosis);
		return medicalCardWithDepartment;

	}

}
