package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;

public class AssignedProcedure {

	private Integer id;
	private Integer medicalCardId;
	private Integer  procedureId ;
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
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	
	

	 
}
