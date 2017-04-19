package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.MedicalCard;

public interface IMedicalCardService {

	MedicalCard getById(Integer id);

	List<MedicalCard> getByDepartmentId(Integer departmentId);

	List<MedicalCard> getAll();

	List<MedicalCard> getByDoctorId(Integer medicalWorkerId);

	@Transactional
	void save(MedicalCard medicalCard);

	@Transactional
	void saveMultiple(MedicalCard... medicalCard);
}
