package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Diagnosis;

public interface IDiagnosisDao {
	Diagnosis getById(Integer id);

	List<Diagnosis> getAll();

	Diagnosis insert(Diagnosis diagnosis);
}
