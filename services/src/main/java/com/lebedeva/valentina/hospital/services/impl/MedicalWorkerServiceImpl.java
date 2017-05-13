package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IMedicalWorkerDao;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorkerWithDepartment;
import com.lebedeva.valentina.hospital.datamodel.Position;
import com.lebedeva.valentina.hospital.services.IMedicalWorkerService;

@Service
public class MedicalWorkerServiceImpl implements IMedicalWorkerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalWorkerServiceImpl.class);

	@Inject
	private IMedicalWorkerDao medicalWorkerDao;

	@Override
	public MedicalWorker getById(Integer id) {
		return medicalWorkerDao.getById(id);
	}

	@Override
	public List<MedicalWorker> getByPosition(Position position) {
		return medicalWorkerDao.getByPosition(position);
	}

	@Override
	public List<MedicalWorker> getByActive(Boolean active) {
		return medicalWorkerDao.getByActive(active);
	}

	@Override
	public void save(MedicalWorker medicalWorker) {
		if (medicalWorker.getId() == null) {
			System.out.println("Insert new MedicalWorker");
			medicalWorkerDao.insert(medicalWorker);
			LOGGER.info("New Medical Worker with id = {} added successfully", medicalWorker.getId());
		} else {

			System.out.println("Update MedicalWorker");
			medicalWorkerDao.update(medicalWorker);
			LOGGER.info("Medical Worker updated");
		}
	}

	@Override
	public List<MedicalWorkerWithDepartment> getMedicalWorkerWithDepartment(Position position) {
		return medicalWorkerDao.getMedicalWorkerWithDepartment(position);
	}

}
