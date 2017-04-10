package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Operation;

public interface IOperationService {
	Operation getById(Integer Id);

	List<Operation> getByDiagnosis(Integer diagnosisId);

	List<Operation> getAll();

	@Transactional
	void save(Operation operation);

	@Transactional
	void saveMultiple(Operation... operation);
}
