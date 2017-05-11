package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Procedure;

public interface IProcedureService {
	Procedure getById(Integer Id);

	List<Procedure> getByDiagnosis(Integer diagnosisId);

	List<Procedure> getAll();

	@Transactional
	void save(Procedure procedure);

}
