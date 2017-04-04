package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Department;
import com.lebedeva.valentina.hospital.services.IDepartmentService;

public class TransactionsTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IDepartmentService service = context.getBean(IDepartmentService.class);

		Department department1 = new Department();
		department1.setName("new department in transaction 1");

		Department department2 = new Department();
		department2.setName("new department in transaction 2");

		service.saveMultiple(department1, department2);

	}

}
