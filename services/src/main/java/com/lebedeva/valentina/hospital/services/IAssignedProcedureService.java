package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.AssignedProcedure;

public interface IAssignedProcedureService {
	AssignedProcedure getById(Integer id);

	List<AssignedProcedure> getByMedicalCardId(Integer medicalCardId);

	@Transactional
	void save(AssignedProcedure assignedProcedure);

}
