package com.lebedeva.valentina.hospital.dao.api;

import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Operation;

public interface IOperationDao {
	Operation getById(Integer id);
	
	List<Operation> getByDiagnosis(Integer diagnosisId);
	
	List<Operation> getAll();
	
	Operation insert(Operation operation);

}
