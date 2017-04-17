package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.AssignedOperation;

public interface IAssignedOperationService {
	AssignedOperation getById(Integer id);

	List<AssignedOperation> getByMedicalWorkerId(Integer medicalWorkerId);

	List<AssignedOperation> getByMedicalCardId(Integer medicalCardId);

	List<AssignedOperation> getAll();

	@Transactional
	void save(AssignedOperation assignedOperation);

	@Transactional
	void saveMultiple(AssignedOperation... assignedOperation);
}
