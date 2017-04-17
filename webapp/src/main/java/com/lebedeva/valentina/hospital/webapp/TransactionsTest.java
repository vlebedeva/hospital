package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;
import com.lebedeva.valentina.hospital.services.IAssignedMedicamentService;


public class TransactionsTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IAssignedMedicamentService service = context.getBean(IAssignedMedicamentService.class);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date stDate = new java.sql.Date(date.getTime());
		
		AssignedMedicament assignedMedicament1 = new AssignedMedicament();
		assignedMedicament1.setMedicalCardId(3);
		assignedMedicament1.setMedicamentId(1);
		assignedMedicament1.setAssigned(stDate);
		assignedMedicament1.setAnnotation("new assignedMedicament in transaction 1");

		AssignedMedicament assignedMedicament2 = new AssignedMedicament();
		assignedMedicament2.setMedicalCardId(1);
		assignedMedicament2.setMedicamentId(1);
		assignedMedicament2.setAssigned(stDate);
		assignedMedicament2.setAnnotation("new assignedMedicament in transaction 2");

		service.saveMultiple(assignedMedicament1, assignedMedicament2);

	}

}
