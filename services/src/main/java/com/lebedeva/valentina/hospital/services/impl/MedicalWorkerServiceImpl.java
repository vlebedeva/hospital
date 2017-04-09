package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.lebedeva.valentina.hospital.dao.impl.db.IMedicalWorkerDao;
import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
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
	public List<MedicalWorker> getByDepartmentId(Integer departmentId) {
		return medicalWorkerDao.getByDepartmentId(departmentId);
	}

	@Override
	public List<MedicalWorker> getByCategoty(Category category) {
		return medicalWorkerDao.getByCategoty(category);
	}

	@Override
	public List<MedicalWorker> getByPosition(Position position) {
		return medicalWorkerDao.getByPosition(position);
	}

	@Override
	public List<MedicalWorker> getBySpecialization(String specialization) {
		return medicalWorkerDao.getBySpecialization(specialization);
	}

	@Override
	public List<MedicalWorker> getAll() {
		return medicalWorkerDao.getAll();
	}

	@Override
	public List<MedicalWorker> getAllActive(Boolean active) {
		return medicalWorkerDao.getAllActive(active);
	}

	@Override
	public void save(MedicalWorker medicalWorker) {
		if (medicalWorker.getId() == null) {
			System.out.println("Insert new MedicalWorker");
			medicalWorkerDao.insert(medicalWorker);
		} else {

			System.out.println("Update MedicalWorker");
			medicalWorkerDao.update(medicalWorker);
		}
	}

	@Override
	public void saveMultiple(MedicalWorker... medicalWorkerArray) {

		for (MedicalWorker medicalWorker : medicalWorkerArray) {
			save(medicalWorker);
		}

	}
}
