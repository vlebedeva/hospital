package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.MedicalCard;

public interface IMedicalCardDao {
	MedicalCard getById(Integer id);

	List<MedicalCard> getNotDischarge();

	List<MedicalCard> getByDoctorId(Integer medicalWorkerId);

	MedicalCard insert(MedicalCard medicalCard);

	void update(MedicalCard medicalCard);
}
