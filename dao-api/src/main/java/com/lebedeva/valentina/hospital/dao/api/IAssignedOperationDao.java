package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.AssignedOperation;

public interface IAssignedOperationDao {
	AssignedOperation getById(Integer id);

	List<AssignedOperation> getByMedicalWorkerId(Integer medicalWorkerId);

	List<AssignedOperation> getByMedicalCardId(Integer medicalCardId);

	List<AssignedOperation> getAll();

	AssignedOperation insert(AssignedOperation assignedOperation);

	void update(AssignedOperation assignedOperation);
}
