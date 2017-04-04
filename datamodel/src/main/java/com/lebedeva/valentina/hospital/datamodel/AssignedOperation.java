package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;

public class AssignedOperation {

	private Integer id;
	private Integer medicalCardId;
	private Integer operationId;
	private Date assigned;
	private String executor;
	private Date done;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMedicalCardId() {
		return medicalCardId;
	}

	public void setMedicalCardId(Integer medicalCardId) {
		this.medicalCardId = medicalCardId;
	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public Date getAssigned() {
		return assigned;
	}

	public void setAssigned(Date assigned) {
		this.assigned = assigned;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public Date getDone() {
		return done;
	}

	public void setDone(Date done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return String.format(
				"AssignedOperation [id = %s medicalCardId = %s operationId = %s assigned = %s executor = %s done = %s]",
				id, medicalCardId, operationId, assigned, executor, done);
				
	}

}
