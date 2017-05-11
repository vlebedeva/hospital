package com.lebedeva.valentina.hospital.datamodel;

import java.sql.Date;

public class MedicalCard {

	private Integer id;
	private String patientFullName;
	private Date birthday;
	private String pasport;
	private Integer diagnosisId;
	private Integer medicalWorkerId;
	private Integer departmentId;
	private Date enterDate;
	private Date dischargeDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientFullName() {
		return patientFullName;
	}

	public void setPatientFullName(String patientFullName) {
		this.patientFullName = patientFullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPasport() {
		return pasport;
	}

	public void setPasport(String pasport) {
		this.pasport = pasport;
	}

	public Integer getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public Integer getMedicalWorkerId() {
		return medicalWorkerId;
	}

	public void setMedicalWorkerId(Integer medicalWorkerId) {
		this.medicalWorkerId = medicalWorkerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	@Override
	public String toString() {
		return String.format(
				"MedicalCard [id = %s patientFullName = %s birthday = %s  pasport = %s  diagnosisId = %s medicalWorkerId = %s departmentId = %s enterDate = %s dischargeDate = %s]",
				id, patientFullName, birthday, pasport, diagnosisId, medicalWorkerId, departmentId, enterDate,
				dischargeDate);
	}

}
