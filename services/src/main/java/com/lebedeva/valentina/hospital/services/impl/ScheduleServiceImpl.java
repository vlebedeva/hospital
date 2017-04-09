package com.lebedeva.valentina.hospital.services.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.impl.db.IScheduleDao;

import com.lebedeva.valentina.hospital.datamodel.Schedule;
import com.lebedeva.valentina.hospital.services.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Inject
	private IScheduleDao scheduleDao;

	@Override
	public Schedule getById(Integer id) {
		return scheduleDao.getById(id);
	}

	@Override
	public List<Schedule> getByMedicalWorkerId(Integer medicalWorkerId) {
		return scheduleDao.getByMedicalWorkerId(medicalWorkerId);
	}

	@Override
	public List<Schedule> getByDate(Date date) {
		return scheduleDao.getByDate(date);
	}

	@Override
	public List<Schedule> getAll() {
		return scheduleDao.getAll();
	}

	@Override
	public void save(Schedule schedule) {
		if (schedule.getId() == null) {
			System.out.println("Insert new Schedule");
			scheduleDao.insert(schedule);
		} else {

			System.out.println("Update Schedule");
			scheduleDao.update(schedule);
		}
	}

	@Override
	public void saveMultiple(Schedule... scheduleArray) {

		for (Schedule schedule : scheduleArray) {
			save(schedule);
		}

	}

}
