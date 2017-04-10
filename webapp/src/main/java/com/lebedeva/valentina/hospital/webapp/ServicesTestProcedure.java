package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Procedure;
import com.lebedeva.valentina.hospital.services.IProcedureService;

public class ServicesTestProcedure {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IProcedureService service = context.getBean(IProcedureService.class);

		System.out.println(service.getById(1));
		System.out.println(service.getAll());

		Procedure procedure = new Procedure(); // new object type Operation
		service.getById(procedure.getId()); // empty object

		System.out.println(service.getByDiagnosis(1));

		procedure.setId(2);
		procedure.setName("procedure from java");
		procedure.setDiagnosisId(3);

		service.save(procedure);

		System.out.println(service.getById(procedure.getId()));
	}

}
