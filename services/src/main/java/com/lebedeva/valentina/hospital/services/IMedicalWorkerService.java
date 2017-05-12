package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorkerWithDepartment;
import com.lebedeva.valentina.hospital.datamodel.Position;


public interface IMedicalWorkerService {
	MedicalWorker getById(Integer id);
	
	List<MedicalWorkerWithDepartment> getMedicalWorkerWithDepartment(Position position);
	
	List<MedicalWorker> getByPosition(Position position);

	List<MedicalWorker> getByActive(Boolean active);
	
	@Transactional
	void save(MedicalWorker medicalWorker);

}
