package com.lebedeva.valentina.hospital.dao.api;

import java.sql.Date;
import java.util.List;

import com.lebedeva.valentina.hospital.datamodel.Schedule;

public interface IScheduleDao {

	Schedule getById(Integer Id);

	List<Schedule> getByMedicalWorkerId(Integer medicalWorkerId);

	List<Schedule> getByDate(Date date);

	List<Schedule> getAll();

	Schedule insert(Schedule schedule);

	void update(Schedule schedule);
}
