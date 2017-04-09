package com.lebedeva.valentina.hospital.dao.impl.db;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.Position;

public interface IMedicalWorkerDao {
	
	MedicalWorker getById(Integer id);

	List<MedicalWorker> getByDepartmentId(Integer departmentId);

	List<MedicalWorker> getByCategoty(Category category);
	
	List<MedicalWorker> getByPosition(Position position);

	List<MedicalWorker> getBySpecialization (String specialization);
	
	List<MedicalWorker> getAll();
	
	List<MedicalWorker> getAllActive(Boolean active);
	
	MedicalWorker insert(MedicalWorker medicalWorker);

	void update(MedicalWorker medicalWorker);
}
