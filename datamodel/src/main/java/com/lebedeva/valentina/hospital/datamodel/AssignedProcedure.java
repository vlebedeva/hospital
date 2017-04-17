package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;
import java.sql.Time;

public class AssignedProcedure {

	private Integer id;
	private Integer medicalCardId;
	private Integer procedureId;
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

	public Integer getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Integer procedureId) {
		this.procedureId = procedureId;
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
				"AssignedProcedure [id = %s medicalCardId = %s procedureId = %s assigned = %s medicalWorkerId = %s done = %s annotation=%s]",
				id, medicalCardId, procedureId, assigned, medicalWorkerId, done, annotation);
	}

}
