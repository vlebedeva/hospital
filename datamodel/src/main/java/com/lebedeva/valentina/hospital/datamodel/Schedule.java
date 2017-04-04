package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;

public class Schedule {

	private Integer id;
	private Integer medicalWorkerId;
	private Date start;
	private Date end;

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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return String.format("Schedule [id = %s medicalWorkerId = %s start = %s end = %s]", id, medicalWorkerId, start,
				end);
	}

}
