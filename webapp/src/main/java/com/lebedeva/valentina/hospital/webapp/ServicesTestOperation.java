package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Operation;
import com.lebedeva.valentina.hospital.services.IOperationService;

public class ServicesTestOperation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IOperationService service = context.getBean(IOperationService.class);

		System.out.println(service.getById(1));
		System.out.println(service.getAll());

		Operation operation = new Operation(); // new object type Operation
		service.getById(operation.getId()); // empty object

		System.out.println(service.getByDiagnosis(3));

		operation.setId(2);
		operation.setName("operation from java");
		operation.setDiagnosisId(3);

		service.save(operation);

		System.out.println(service.getById(operation.getId()));
	}

}
