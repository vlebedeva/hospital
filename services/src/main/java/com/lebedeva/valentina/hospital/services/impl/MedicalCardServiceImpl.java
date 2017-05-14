package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IMedicalCardDao;
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
	public void save(MedicalCard medicalCard) {
		if (medicalCard.getId() == null) {
			System.out.println("Insert new MedicalCard");
			medicalCardDao.insert(medicalCard);
			LOGGER.info("New Medical Card with id = {} added successfully", medicalCard.getId());
		} else {
			System.out.println("Update MedicalCard");
			medicalCardDao.update(medicalCard);
			LOGGER.info("Medical Card updated");
		}
	}

	@Override
	public List<MedicalCard> getNotDischarge() {
		return medicalCardDao.getNotDischarge();
	}

	@Override
	public List<MedicalCard> getByDoctorId(Integer medicalWorkerId) {
		return medicalCardDao.getByDoctorId(medicalWorkerId);
	}

}
