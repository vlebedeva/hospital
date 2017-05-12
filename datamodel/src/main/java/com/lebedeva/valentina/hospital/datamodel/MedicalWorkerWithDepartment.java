package com.lebedeva.valentina.hospital.datamodel;

public class MedicalWorkerWithDepartment {

	private MedicalWorker medicalWorker;
	private Department department;

	public MedicalWorker getMedicalWorker() {
		return medicalWorker;
	}

	public void setMedicalWorker(MedicalWorker medicalWorker) {
		this.medicalWorker = medicalWorker;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
