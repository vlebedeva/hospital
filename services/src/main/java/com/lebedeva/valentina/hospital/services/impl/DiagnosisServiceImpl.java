package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IDiagnosisDao;
import com.lebedeva.valentina.hospital.datamodel.Diagnosis;
import com.lebedeva.valentina.hospital.services.IDiagnosisService;

@Service
public class DiagnosisServiceImpl implements IDiagnosisService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosisServiceImpl.class);

	@Inject
	private IDiagnosisDao diagnosisDao;

	@Override
	public Diagnosis get(Integer id) {
		return diagnosisDao.get(id);
	}

	@Override
	public List<Diagnosis> getAll() {
		return diagnosisDao.getAll();
	}

	@Override
	public void save(Diagnosis diagnosis) {
		if (diagnosis.getId() == null) {
			System.out.println("Insert new Diagnosis");
			diagnosisDao.insert(diagnosis);
		} else {

			System.out.println("Update Diagnosis");
			diagnosisDao.update(diagnosis);
		}
	}

	@Override
	public void delete(Integer id) {
		diagnosisDao.delete(id);

	}

	@Override
	public void saveMultiple(Diagnosis... diagnosisArray) {

		for (Diagnosis diagnosis : diagnosisArray) {
			save(diagnosis);
		}

	}
}
