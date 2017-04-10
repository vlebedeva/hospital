package com.lebedeva.valentina.hospital.dao.impl.db;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Medicament;

public interface IMedicamentDao {
	Medicament getById(Integer id);
	
	List<Medicament> getByDiagnosis(Integer diagnosisId);
	
	List<Medicament> getAll();
	
	Medicament insert(Medicament medicament);

	void update(Medicament medicament);
}
