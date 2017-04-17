package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.impl.db.IAssignedProcedureDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;
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
	public List<AssignedProcedure> getByMedicalWorkerId(Integer medicalWorkerId) {
		return assignedProcedureDao.getByMedicalWorkerId(medicalWorkerId);
	}

	@Override
	public List<AssignedProcedure> getByMedicalCardId(Integer medicalCardId) {
		return assignedProcedureDao.getByMedicalCardId(medicalCardId);
	}

	@Override
	public List<AssignedProcedure> getAll() {
		return assignedProcedureDao.getAll();
	}

	@Override
	public void save(AssignedProcedure assignedProcedure) {
		if (assignedProcedure.getId() == null) {
			System.out.println("Insert new AssignedProcedure");
			assignedProcedureDao.insert(assignedProcedure);
		} else {

			System.out.println("Update AssignedMedicament");
			assignedProcedureDao.update(assignedProcedure);
		}
	}

	@Override
	public void saveMultiple(AssignedProcedure... assignedProcedureArray) {
		for (AssignedProcedure assignedProcedure : assignedProcedureArray) {
			save(assignedProcedure);
		}

	}

}
