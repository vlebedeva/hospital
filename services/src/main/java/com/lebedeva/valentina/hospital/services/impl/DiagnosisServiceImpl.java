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
	public Diagnosis getById(Integer id) {
		return diagnosisDao.getById(id);
	}

	@Override
	public List<Diagnosis> getAll() {
		return diagnosisDao.getAll();
	}

	@Override
	public void save(Diagnosis diagnosis) {
		if (diagnosis.getId() == null) {
			LOGGER.info("Insert new Diagnosis");
			diagnosisDao.insert(diagnosis);
		}
	}

}
