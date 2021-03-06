package com.lebedeva.valentina.hospital.datamodel;

public class Procedure {

	private Integer id;
	private String name;
	private Integer diagnosisId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	@Override
	public String toString() {
		return String.format("Procedure [id = %s name = %s diagnosisId = %s]", id, name, diagnosisId);
	}
}
