package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.lebedeva.valentina.hospital.datamodel.Diagnosis;

public interface IDiagnosisService {
	Diagnosis get(Integer id);

	List<Diagnosis> getAll();

	@Transactional
	void save(Diagnosis diagnosis);

	@Transactional
	void saveMultiple(Diagnosis... diagnosis);

	@Transactional
	void delete(Integer id);
}
