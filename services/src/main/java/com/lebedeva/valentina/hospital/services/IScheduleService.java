package com.lebedeva.valentina.hospital.services;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Schedule;

public interface IScheduleService {

	Schedule getById(Integer Id);

	List<Schedule> getByMedicalWorkerId(Integer medicalWorkerId);

	List<Schedule> getByDate(Date date);

	List<Schedule> getAll();

	@Transactional
	void save(Schedule schedule);

	@Transactional
	void saveMultiple(Schedule... schedule);
}
