package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.services.IDepartmentService;

public class ServicesTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IDepartmentService service = context.getBean(IDepartmentService.class);

		System.out.println(service.get(1));
		System.out.println(service.getAll());

		Department department = new Department(); // new object type Department
		service.get(department.getId()); // empty object

		service.get(2);
		System.out.println(service.get(2));
		//department.setId(2);
		//department.setName("department 5");

		//System.out.println(department);
		// service.save(department);
		// System.out.println(service.get(2));

		// System.out.println("Saved department:" + department);
		// System.out.println(service.getAll());
		 //System.out.println(service.get(department.getId()));
		// service.delete(department.getId());
		// System.out.println(service.get(department.getId()));
	}
}
