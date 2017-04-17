package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;
import java.sql.Time;

public class AssignedOperation {

	private Integer id;
	private Integer medicalCardId;
	private Integer operationId;
	private Date assigned;
	private Integer medicalWorkerId;
	private Time done;
	private String annotation;

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

	public Integer getMedicalWorkerId() {
		return medicalWorkerId;
	}

	public void setMedicalWorkerId(Integer medicalWorkerId) {
		this.medicalWorkerId = medicalWorkerId;
	}

	public Time getDone() {
		return done;
	}

	public void setDone(Time done) {
		this.done = done;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	@Override
	public String toString() {
		return String.format(
				"AssignedOperation [id = %s medicalCardId = %s operationId = %s assigned = %s medicalWorkerId = %s done = %s annotation= %s]",
				id, medicalCardId, operationId, assigned, medicalWorkerId, done, annotation);

	}

}
