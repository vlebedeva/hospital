package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IAssignedProcedureDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedProcedure;
import com.lebedeva.valentina.hospital.services.IAssignedProcedureService;

@Service
public class AssignedProcedureServiceImpl implements IAssignedProcedureService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssignedProcedureServiceImpl.class);

	@Inject
	private IAssignedProcedureDao assignedProcedureDao;

	@Override
	public AssignedProcedure getById(Integer id) {
		return assignedProcedureDao.getById(id);
	}

	@Override
	public List<AssignedProcedure> getByMedicalCardId(Integer medicalCardId) {
		return assignedProcedureDao.getByMedicalCardId(medicalCardId);
	}

	@Override
	public void save(AssignedProcedure assignedProcedure) {
		if (assignedProcedure.getId() == null) {
			LOGGER.info("Insert new AssignedProcedure");
			assignedProcedureDao.insert(assignedProcedure);
		} else {
			LOGGER.info("Update AssignedProcedure");
			assignedProcedureDao.update(assignedProcedure);
		}
	}
}
