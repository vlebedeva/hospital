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

	@Override
	public String toString() {
		return "MedicalWorkerWithDepartment [full_name=" + medicalWorker.getFullName() + ", specialization=" + medicalWorker.getSpecialization() + ", category=" + medicalWorker.getCategory() +", department=" + department.getName() + "]";
	}

}
