package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.Position;


public interface IMedicalWorkerService {
	MedicalWorker getById(Integer id);

	List<MedicalWorker> getByDepartmentId(Integer departmentId);

	List<MedicalWorker> getByCategoty(Category category);
	
	List<MedicalWorker> getByPosition(Position position);

	List<MedicalWorker> getBySpecialization (String specialization);
	
	List<MedicalWorker> getAll();
	
	List<MedicalWorker> getAllActive(Boolean active);
	
	@Transactional
	void save(MedicalWorker medicalWorker);

	@Transactional
	void saveMultiple(MedicalWorker... medicalWorker);
}
