package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;
import java.sql.Time;

public class AssignedMedicament {

	private Integer id;
	private Integer medicalCardId;
	private Integer medicamentId;
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

	public Integer getMedicamentId() {
		return medicamentId;
	}

	public void setMedicamentId(Integer medicamentId) {
		this.medicamentId = medicamentId;
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
				"AssignedMedicament [id = %s medicalCardId = %s medicamentId = %s assigned = %s medicalWorkerId = %s done = %s annotation=%s]",
				id, medicalCardId, medicamentId, assigned, medicalWorkerId, done, annotation);

	}

}
