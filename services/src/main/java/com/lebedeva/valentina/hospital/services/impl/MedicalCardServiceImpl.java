package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.impl.db.IMedicalCardDao;
import com.lebedeva.valentina.hospital.datamodel.MedicalCard;
import com.lebedeva.valentina.hospital.services.IMedicalCardService;

@Service
public class MedicalCardServiceImpl implements IMedicalCardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalCardServiceImpl.class);

	@Inject
	private IMedicalCardDao medicalCardDao;

	@Override
	public MedicalCard getById(Integer id) {
		return medicalCardDao.getById(id);
	}

	@Override
	public List<MedicalCard> getByDepartmentId(Integer departmentId) {
		return medicalCardDao.getByDepartmentId(departmentId);
	}

	@Override
	public List<MedicalCard> getAll() {
		return medicalCardDao.getAll();
	}

	@Override
	public List<MedicalCard> getByDoctorId(Integer medicalWorkerId) {
		return medicalCardDao.getByDoctorId(medicalWorkerId);
	}

	@Override
	public void save(MedicalCard medicalCard) {
		if (medicalCard.getId() == null) {
			System.out.println("Insert new MedicalCard");
			medicalCardDao.insert(medicalCard);
		} else {

			System.out.println("Update MedicalCard");
			medicalCardDao.update(medicalCard);
		}

	}

	@Override
	public void saveMultiple(MedicalCard... medicalCardArray) {
		for (MedicalCard medicalCard : medicalCardArray) {
			save(medicalCard);
		}
	}

}
