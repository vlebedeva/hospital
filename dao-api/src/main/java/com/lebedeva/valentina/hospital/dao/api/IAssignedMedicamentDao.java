package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;

public interface IAssignedMedicamentDao {
	AssignedMedicament getById(Integer id);

	List<AssignedMedicament> getByMedicalCardId(Integer medicalCardId);

	AssignedMedicament insert(AssignedMedicament assignedMedicament);

	void update(AssignedMedicament assignedMedicament);
}
