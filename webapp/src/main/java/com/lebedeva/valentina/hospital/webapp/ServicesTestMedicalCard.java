package com.lebedeva.valentina.hospital.webapp;

import java.sql.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lebedeva.valentina.hospital.datamodel.MedicalCard;
import com.lebedeva.valentina.hospital.services.IMedicalCardService;

public class ServicesTestMedicalCard {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IMedicalCardService service = context.getBean(IMedicalCardService.class);

		System.out.println(service.getById(1));

		MedicalCard medicalCard = new MedicalCard(); // new object type
														// MedicalCard
		service.getById(medicalCard.getId()); // empty object

		
		
		System.out.println(service.getMedicalCardWithDepartment(3));

		/*java.util.Date date = new java.util.Date();
		java.sql.Date stDate = new java.sql.Date(date.getTime());

		medicalCard.setId(3);
		medicalCard.setPatientFullName("patient from java");
		medicalCard.setBirthday(stDate.valueOf("1987-03-17"));
		medicalCard.setDepartmentId(2);
		medicalCard.setPasport("docunent from java");
		medicalCard.setDiagnosisId(3);
		medicalCard.setEnterDate(stDate);
		medicalCard.setMedicalWorkerId(4);

		service.save(medicalCard);

		System.out.println(service.getById(medicalCard.getId()));*/

	}

}
