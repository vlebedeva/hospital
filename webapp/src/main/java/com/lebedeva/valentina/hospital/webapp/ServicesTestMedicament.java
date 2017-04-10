package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Medicament;

import com.lebedeva.valentina.hospital.services.IMedicamentService;

public class ServicesTestMedicament {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IMedicamentService service = context.getBean(IMedicamentService.class);

		System.out.println(service.getById(1));
		System.out.println(service.getAll());

		Medicament medicament = new Medicament(); // new object type Medicament
		service.getById(medicament.getId()); // empty object

		System.out.println(service.getByDiagnosis(1));

		medicament.setId(2);
		medicament.setName("medicament from java");
		medicament.setDiagnosisId(3);

		service.save(medicament);

		System.out.println(service.getById(medicament.getId()));
	}

}
