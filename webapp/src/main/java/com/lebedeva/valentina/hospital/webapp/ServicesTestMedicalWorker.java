package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Category;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.Position;
import com.lebedeva.valentina.hospital.services.IMedicalWorkerService;

public class ServicesTestMedicalWorker {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IMedicalWorkerService service = context.getBean(IMedicalWorkerService.class);

		System.out.println(service.getById(1));

		MedicalWorker medicalWorker = new MedicalWorker(); // new object type
															// MedicalWorker
		service.getById(medicalWorker.getId()); // empty object

		System.out.println(service.getByPosition(Position.DOCTOR));

		/*
		 * medicalWorker.setId(2);
		 * medicalWorker.setFullName("doctor from java");
		 * medicalWorker.setDepartmentId(2);
		 * medicalWorker.setCategory(Category.first);
		 * medicalWorker.setPosition(Position.DOCTOR);
		 * medicalWorker.setSpecialization("good doctor");
		 * medicalWorker.setActive(true); medicalWorker.setEmail("asd@dfg.vf");
		 * 
		 * service.save(medicalWorker);
		 * 
		 * System.out.println(service.getById(medicalWorker.getId()));
		 */

		System.out.println(service.getByActive(false));

	}

}
