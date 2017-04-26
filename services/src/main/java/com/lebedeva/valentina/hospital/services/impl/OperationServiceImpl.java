package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IOperationDao;
import com.lebedeva.valentina.hospital.datamodel.Operation;
import com.lebedeva.valentina.hospital.services.IOperationService;

@Service
public class OperationServiceImpl implements IOperationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationServiceImpl.class);

	@Inject
	private IOperationDao operationDao;

	@Override
	public Operation getById(Integer id) {
		return operationDao.getById(id);
	}

	@Override
	public List<Operation> getByDiagnosis(Integer diagnosisId) {
		return operationDao.getByDiagnosis(diagnosisId);
	}

	@Override
	public List<Operation> getAll() {
		return operationDao.getAll();
	}

	@Override
	public void save(Operation operation) {
		if (operation.getId() == null) {
			System.out.println("Insert new Operation");
			operationDao.insert(operation);
		} else {

			System.out.println("Update Operation");
			operationDao.update(operation);
		}
	}

	@Override
	public void saveMultiple(Operation... operationArray) {

		for (Operation operation : operationArray) {
			save(operation);
		}

	}
}
