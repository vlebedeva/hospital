package com.lebedeva.valentina.hospital.datamodel;

public class Diagnosis {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return  String.format("Diagnosis [id = %s name = %s]", id, name);
	}
}
