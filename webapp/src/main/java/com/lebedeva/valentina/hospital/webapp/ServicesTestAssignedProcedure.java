package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.AssignedProcedure;
import com.lebedeva.valentina.hospital.services.IAssignedProcedureService;

public class ServicesTestAssignedProcedure {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IAssignedProcedureService service = context.getBean(IAssignedProcedureService.class);

		System.out.println(service.getById(3));

		AssignedProcedure assignedProcedure = new AssignedProcedure(); // new
																		// object
																		// type
																		// AssignedProcedure
		service.getById(assignedProcedure.getId()); // empty object

		// service.getById(3);
		// System.out.println(service.getById(3));

		assignedProcedure.setMedicalCardId(3);
		assignedProcedure.setProcedureId(2);

		assignedProcedure.setAnnotation("evening");

		java.util.Date date = new java.util.Date();
		java.sql.Date stDate = new java.sql.Date(date.getTime());
		java.sql.Time time = new java.sql.Time(date.getTime());

		// for update
		assignedProcedure.setAssigned(stDate);
		assignedProcedure.setDone(time);
		assignedProcedure.setMedicalWorkerId(3);
		assignedProcedure.setId(2);

		System.out.println(assignedProcedure);
		service.save(assignedProcedure);

		System.out.println("Saved assignedProcedure:" + assignedProcedure);

	}

}
