package com.lebedeva.valentina.hospital.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lebedeva.valentina.hospital.datamodel.Schedule;
import com.lebedeva.valentina.hospital.services.IScheduleService;

public class ServicesTestSchedule {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

		IScheduleService service = context.getBean(IScheduleService.class);

		System.out.println(service.getById(1));
		System.out.println(service.getAll());

		Schedule schedule = new Schedule(); // new object type Department
		service.getById(schedule.getId()); // empty object

		service.getById(2);
		System.out.println(service.getById(2));
		schedule.setId(2);
		schedule.setMedicalWorkerId(3);

		// ---------------java.util.Date date = new java.util.Date();
		// ---------------java.sql.Timestamp sqlTimestamp = new
		// ---------------java.sql.Timestamp(date.getTime());

		java.util.Date date = new java.util.Date();
		java.sql.Date stDate = new java.sql.Date(date.getTime());
		java.sql.Time time = new java.sql.Time(date.getTime());
		schedule.setStartDate(stDate.valueOf("2017-05-01"));
		schedule.setStartTime(time.valueOf("08:00:00"));
		schedule.setStopDate(stDate);
		schedule.setStopTime(time);

		System.out.println(schedule);
		service.save(schedule);

		System.out.println("Saved schedule:" + schedule);
		System.out.println(service.getAll());

		// for MedicalWorkerId
		System.out.println(service.getByMedicalWorkerId(3));

		// for date
		System.out.println(service.getByDate(stDate.valueOf("2017-05-01")));

	}

}
