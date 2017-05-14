package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;
import java.sql.Time;

public class Schedule {

	private Integer id;
	private Integer medicalWorkerId;
	private Date startDate;
	private Time startTime;
	private Date endDate;
	private Time endTime;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return String.format(
				"Schedule [id = %s medicalWorkerId = %s startDate = %s startTime = %s endDate = %s endTime = %s]", id,
				medicalWorkerId, startDate, startTime, endDate, endTime);
	}

}
