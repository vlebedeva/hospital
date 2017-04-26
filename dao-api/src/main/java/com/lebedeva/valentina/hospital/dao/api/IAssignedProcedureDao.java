package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.AssignedProcedure;

public interface IAssignedProcedureDao {
	AssignedProcedure getById(Integer id);

	List<AssignedProcedure> getByMedicalWorkerId(Integer medicalWorkerId);

	List<AssignedProcedure> getByMedicalCardId(Integer medicalCardId);

	List<AssignedProcedure> getAll();

	AssignedProcedure insert(AssignedProcedure assignedProcedure);

	void update(AssignedProcedure assignedProcedure);
}
