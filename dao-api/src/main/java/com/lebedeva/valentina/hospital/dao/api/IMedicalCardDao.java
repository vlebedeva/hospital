package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.MedicalCard;
import com.lebedeva.valentina.hospital.datamodel.MedicalCardWithDepartment;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorkerWithDepartment;
import com.lebedeva.valentina.hospital.datamodel.Position;

public interface IMedicalCardDao {
	MedicalCard getById(Integer id);

	List<MedicalCard> getNotDischarge();

	List<MedicalCard> getByDoctorId(Integer medicalWorkerId);
	
	List<MedicalCardWithDepartment> getMedicalCardWithDepartment(Integer id);

	MedicalCard insert(MedicalCard medicalCard);

	void update(MedicalCard medicalCard);
}
