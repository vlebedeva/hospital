package com.lebedeva.valentina.hospital.datamodel;

enum Position {
	DOCTOR, NURSE
}

public class MedicalWorker {

	private Integer id;
	private String fullName;
	private Position position;
	private String specialization;
	private String category;
	private Integer departmentId;
	private Boolean active;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format(
				"MedicalWorker [id = %s fullName = %s position = %s specialization = %s category = %s departmentId = %s email = %s active = %s]",
				id, fullName, position, specialization, category, departmentId, email, active);
	}

}
