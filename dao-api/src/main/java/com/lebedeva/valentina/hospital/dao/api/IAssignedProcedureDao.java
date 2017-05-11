package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.AssignedProcedure;

public interface IAssignedProcedureDao {
	AssignedProcedure getById(Integer id);

	List<AssignedProcedure> getByMedicalCardId(Integer medicalCardId);

	AssignedProcedure insert(AssignedProcedure assignedProcedure);

	void update(AssignedProcedure assignedProcedure);
}
