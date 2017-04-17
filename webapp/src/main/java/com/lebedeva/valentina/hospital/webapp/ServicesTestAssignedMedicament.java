package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;
import com.lebedeva.valentina.hospital.services.IAssignedMedicamentService;

public class ServicesTestAssignedMedicament {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IAssignedMedicamentService service = context.getBean(IAssignedMedicamentService.class);

		System.out.println(service.getById(3));
		System.out.println(service.getAll());

		AssignedMedicament assignedMedicament = new AssignedMedicament(); // new object type AssignedMedicament
		service.getById(assignedMedicament.getId()); // empty object

		service.getById(3);
		System.out.println(service.getById(3));
	
		assignedMedicament.setMedicalCardId(3);
		assignedMedicament.setMedicamentId(5);
	
		assignedMedicament.setAnnotation("evening");

		java.util.Date date = new java.util.Date();
		java.sql.Date stDate = new java.sql.Date(date.getTime());
		java.sql.Time time = new java.sql.Time(date.getTime());

		//for update
		assignedMedicament.setAssigned(stDate);
		//assignedMedicament.setDone(time);
		//assignedMedicament.setMedicalWorkerId(3);
		//assignedMedicament.setId(4);

		System.out.println(assignedMedicament);
		service.save(assignedMedicament);

		System.out.println("Saved assignedMedicament:" + assignedMedicament);
		System.out.println(service.getAll());

	
	}

}
