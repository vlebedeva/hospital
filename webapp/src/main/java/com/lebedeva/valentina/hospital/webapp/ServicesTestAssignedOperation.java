package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.AssignedOperation;
import com.lebedeva.valentina.hospital.services.IAssignedOperationService;

public class ServicesTestAssignedOperation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IAssignedOperationService service = context.getBean(IAssignedOperationService.class);

		System.out.println(service.getById(2));
		System.out.println(service.getAll());

		AssignedOperation assignedOperation = new AssignedOperation(); // new object type AssignedMedicament
		service.getById(assignedOperation.getId()); // empty object

			
		assignedOperation.setMedicalCardId(3);
		assignedOperation.setOperationId(3);
	
		assignedOperation.setAnnotation("evening");

		java.util.Date date = new java.util.Date();
		java.sql.Date stDate = new java.sql.Date(date.getTime());
		java.sql.Time time = new java.sql.Time(date.getTime());

		//for update
		assignedOperation.setAssigned(stDate);
		//assignedOperation.setDone(time);
		//assignedOperation.setMedicalWorkerId(3);
		assignedOperation.setId(1);

		System.out.println(assignedOperation);
		service.save(assignedOperation);

		System.out.println("Saved assignedOperation:" + assignedOperation);
		System.out.println(service.getAll());

	
	}

}
