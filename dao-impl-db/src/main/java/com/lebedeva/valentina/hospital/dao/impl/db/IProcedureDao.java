package com.lebedeva.valentina.hospital.dao.impl.db;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Procedure;

public interface IProcedureDao {
	Procedure getById(Integer id);

	List<Procedure> getByDiagnosis(Integer diagnosisId);

	List<Procedure> getAll();

	Procedure insert(Procedure procedure);

	void update(Procedure procedure);
}
