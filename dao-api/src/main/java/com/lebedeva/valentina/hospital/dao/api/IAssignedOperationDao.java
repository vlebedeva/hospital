package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.AssignedOperation;

public interface IAssignedOperationDao {
	AssignedOperation getById(Integer id);

	List<AssignedOperation> getByMedicalCardId(Integer medicalCardId);

	AssignedOperation insert(AssignedOperation assignedOperation);

	void update(AssignedOperation assignedOperation);
}
