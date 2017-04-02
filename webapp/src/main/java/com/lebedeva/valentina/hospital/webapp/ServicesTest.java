package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.services.IDepartmentServices;

public class ServicesTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IDepartmentServices service = context.getBean(IDepartmentServices.class);

		System.out.println(service.get(1));
		System.out.println(service.getAll());

		Department department = new Department();
		department.setName("department 5");

		service.save(department);

		System.out.println("Saved department:" + department);

		System.out.println(service.get(department.getId()));
		// service.delete(department.getId());
		System.out.println(service.get(department.getId()));
	}
}
