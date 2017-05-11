package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IAssignedOperationDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedOperation;
import com.lebedeva.valentina.hospital.services.IAssignedOperationService;

@Service
public class AssignedOperationServiceImpl implements IAssignedOperationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssignedProcedureServiceImpl.class);

	@Inject
	private IAssignedOperationDao assignedOperationDao;

	@Override
	public AssignedOperation getById(Integer id) {
		return assignedOperationDao.getById(id);
	}

	@Override
	public List<AssignedOperation> getByMedicalCardId(Integer medicalCardId) {
		return assignedOperationDao.getByMedicalCardId(medicalCardId);
	}

	@Override
	public void save(AssignedOperation assignedOperation) {
		if (assignedOperation.getId() == null) {
			System.out.println("Insert new AssignedOperation");
			assignedOperationDao.insert(assignedOperation);
		} else {
			System.out.println("Update AssignedOperation");
			assignedOperationDao.update(assignedOperation);
		}
	}
}
