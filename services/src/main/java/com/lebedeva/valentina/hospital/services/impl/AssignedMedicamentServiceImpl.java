package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IAssignedMedicamentDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;
import com.lebedeva.valentina.hospital.services.IAssignedMedicamentService;

@Service
public class AssignedMedicamentServiceImpl implements IAssignedMedicamentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignedMedicamentServiceImpl.class);

	@Inject
	private IAssignedMedicamentDao assignedMedicamentDao;

	@Override
	public AssignedMedicament getById(Integer id) {
		return assignedMedicamentDao.getById(id);
	}

	@Override
	public List<AssignedMedicament> getByMedicalWorkerId(Integer medicalWorkerId) {
		return assignedMedicamentDao.getByMedicalWorkerId(medicalWorkerId);
	}

	@Override
	public List<AssignedMedicament> getByMedicalCardId(Integer medicalCardId) {
		return assignedMedicamentDao.getByMedicalCardId(medicalCardId);
	}

	@Override
	public List<AssignedMedicament> getAll() {
		return assignedMedicamentDao.getAll();
	}

	@Override
	public void save(AssignedMedicament assignedMedicament) {
		if (assignedMedicament.getId() == null) {
			System.out.println("Insert new AssignedMedicament");
			assignedMedicamentDao.insert(assignedMedicament);
		} else {

			System.out.println("Update AssignedMedicament");
			assignedMedicamentDao.update(assignedMedicament);
		}

	}

	@Override
	public void saveMultiple(AssignedMedicament... assignedMedicamentArray) {
		for (AssignedMedicament assignedMedicament : assignedMedicamentArray) {
			save(assignedMedicament);
		}

	}

}
