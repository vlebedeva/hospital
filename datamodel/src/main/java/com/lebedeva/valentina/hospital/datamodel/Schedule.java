package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;

public class Schedule {
	  
	private Integer id;
	private Integer  medicalWorkerId;
	private Date  star;
	private Date  end;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMedicalWorkerId() {
		return medicalWorkerId;
	}
	public void setMedicalWorkerId(Integer medicalWorkerId) {
		this.medicalWorkerId = medicalWorkerId;
	}
	public Date getStar() {
		return star;
	}
	public void setStar(Date star) {
		this.star = star;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
}
