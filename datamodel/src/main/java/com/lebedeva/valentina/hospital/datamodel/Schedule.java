package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;
import java.sql.Time;

public class Schedule {

	private Integer id;
	private Integer medicalWorkerId;
	private Date startDate;
	private Time startTime;
	private Date stopDate;
	private Time stopTime;

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

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public Time getStopTime() {
		return stopTime;
	}

	public void setStopTime(Time stopTime) {
		this.stopTime = stopTime;
	}

	@Override
	public String toString() {
		return String.format(
				"Schedule [id = %s medicalWorkerId = %s startDate = %s startTime = %s stopDate = %s stopTime = %s]", id,
				medicalWorkerId, startDate, startTime, stopDate, stopTime);
	}

}
