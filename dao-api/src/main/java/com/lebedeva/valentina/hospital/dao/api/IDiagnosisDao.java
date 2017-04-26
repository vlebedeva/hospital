package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Diagnosis;

public interface IDiagnosisDao {
	Diagnosis get(Integer id);

	List<Diagnosis> getAll();

	Diagnosis insert(Diagnosis diagnosis);

	void update(Diagnosis diagnosis);

	void delete(Integer id);
}
