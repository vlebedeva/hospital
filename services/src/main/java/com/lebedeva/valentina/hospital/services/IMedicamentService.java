package com.lebedeva.valentina.hospital.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Medicament;

public interface IMedicamentService {
	Medicament getById(Integer Id);

	List<Medicament> getByDiagnosis(Integer diagnosisId);

	List<Medicament> getAll();

	@Transactional
	void save(Medicament medicament);

	@Transactional
	void saveMultiple(Medicament... medicament);
}
