package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Diagnosis;
import com.lebedeva.valentina.hospital.services.IDiagnosisService;

public class ServicesTestDiagnosis {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IDiagnosisService service = context.getBean(IDiagnosisService.class);

		System.out.println(service.getById(1));
		System.out.println(service.getAll());

		Diagnosis diagnosis = new Diagnosis(); // new object type Department
		service.getById(diagnosis.getId()); // empty object

		service.getById(2);
		System.out.println(service.getById(2));
		 diagnosis.setId(2);
		diagnosis.setName("diagnosis 5");

		System.out.println(diagnosis);
		service.save(diagnosis);
		System.out.println(service.getById(2));

		System.out.println("Saved diagnosis:" + diagnosis);
		System.out.println(service.getAll());
		System.out.println(service.getById(diagnosis.getId()));
		//service.delete(diagnosis.getId());
		// System.out.println(service.get(diagnosis.getId()));

	}

}
