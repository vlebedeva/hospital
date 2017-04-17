package com.lebedeva.valentina.hospital.dao.impl.db;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;

public interface IAssignedMedicamentDao {
	AssignedMedicament getById(Integer id);

	List<AssignedMedicament> getByMedicalWorkerId(Integer medicalWorkerId);

	List<AssignedMedicament> getByMedicalCardId(Integer medicalCardId);

	List<AssignedMedicament> getAll();

	AssignedMedicament insert(AssignedMedicament assignedMedicament);

	void update(AssignedMedicament assignedMedicament);
}
