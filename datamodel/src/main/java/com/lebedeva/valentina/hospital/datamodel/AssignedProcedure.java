package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;

public class AssignedProcedure {

	private Integer id;
	private Integer medicalCardId;
	private Integer procedureId;
	private Date assigned;
	private Position executor;
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

	public Position getExecutor() {
		return executor;
	}

	public void setExecutor(Position executor) {
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
				"AssignedProcedure [id = %s medicalCardId = %s procedureId = %s assigned = %s executor = %s done = %s]",
				id, medicalCardId, procedureId, assigned, executor, done);
	}

}
