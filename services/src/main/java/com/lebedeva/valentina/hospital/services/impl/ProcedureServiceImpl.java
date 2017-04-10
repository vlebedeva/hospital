package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.impl.db.IProcedureDao;
import com.lebedeva.valentina.hospital.datamodel.Procedure;
import com.lebedeva.valentina.hospital.services.IProcedureService;

@Service
public class ProcedureServiceImpl implements IProcedureService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureServiceImpl.class);

	@Inject
	private IProcedureDao procedureDao;

	@Override
	public Procedure getById(Integer id) {
		return procedureDao.getById(id);
	}

	@Override
	public List<Procedure> getByDiagnosis(Integer diagnosisId) {
		return procedureDao.getByDiagnosis(diagnosisId);
	}

	@Override
	public List<Procedure> getAll() {
		return procedureDao.getAll();
	}

	@Override
	public void save(Procedure procedure) {
		if (procedure.getId() == null) {
			System.out.println("Insert new Procedure");
			procedureDao.insert(procedure);
		} else {

			System.out.println("Update Procedure");
			procedureDao.update(procedure);
		}
	}

	@Override
	public void saveMultiple(Procedure... procedureArray) {

		for (Procedure procedure : procedureArray) {
			save(procedure);
		}

	}
}
