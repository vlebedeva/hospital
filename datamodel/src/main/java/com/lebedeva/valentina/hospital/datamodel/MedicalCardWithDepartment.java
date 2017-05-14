package com.lebedeva.valentina.hospital.datamodel;

public class MedicalCardWithDepartment {

	private MedicalCard medicalCard;
	private Department department;
	private Diagnosis diagnosis;

	public MedicalCard getMedicalCard() {
		return medicalCard;
	}

	public void setMedicalCard(MedicalCard medicalCard) {
		this.medicalCard = medicalCard;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "MedicalCardWithDepartment [id_medical_card=" + medicalCard.getId() + ", patient_full_name="
				+ medicalCard.getPatientFullName() + ", birthday=" + medicalCard.getBirthday() + ", diagnosis="+ diagnosis.getName() + ", department="
				+ department.getName()  +", enter_date="+ medicalCard.getEnterDate() +"]";
	}

}
