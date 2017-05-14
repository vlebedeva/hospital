package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.MedicalCard;
import com.lebedeva.valentina.hospital.datamodel.MedicalCardWithDepartment;

public interface IMedicalCardService {

	MedicalCard getById(Integer id);

	List<MedicalCard> getNotDischarge();
	
	List<MedicalCard> getByDoctorId(Integer medicalWorkerId);

	@Transactional
	void save(MedicalCard medicalCard);
	
	List<MedicalCardWithDepartment> getMedicalCardWithDepartment(Integer medicalWorkerId);

}
