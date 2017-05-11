package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;

public interface IAssignedMedicamentService {
	AssignedMedicament getById(Integer id);

	List<AssignedMedicament> getByMedicalCardId(Integer medicalCardId);

	@Transactional
	void save(AssignedMedicament assignedMedicament);

}
