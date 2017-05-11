package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.Position;

public interface IMedicalWorkerDao {
	
	MedicalWorker getById(Integer id);

	List<MedicalWorker> getByPosition(Position position);

	List<MedicalWorker> getByActive(Boolean active);
	
	MedicalWorker insert(MedicalWorker medicalWorker);

	void update(MedicalWorker medicalWorker);
}
