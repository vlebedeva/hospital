package com.lebedeva.valentina.hospital.dao.db.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lebedeva.valentina.hospital.dao.api.IScheduleDao;
import com.lebedeva.valentina.hospital.datamodel.Schedule;

@Repository
public class ScheduleDaoImpl implements IScheduleDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Schedule getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from schedule where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Schedule>(Schedule.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Schedule> getByMedicalWorkerId(Integer medicalWorkerId) {
		try {
			List<Schedule> rs = jdbcTemplate.query("select * from schedule where medical_worker_id = ? ",
					new Object[] { medicalWorkerId }, new BeanPropertyRowMapper<Schedule>(Schedule.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		/*
		 * for one object try { return jdbcTemplate.
		 * queryForObject("select * from schedule where medical_worker_id = ? ",
		 * new Object[] { medicalWorkerId }, new
		 * BeanPropertyRowMapper<Schedule>(Schedule.class)); } catch
		 * (EmptyResultDataAccessException e) { return null; }
		 */
	}

	@Override
	public List<Schedule> getByDate(Date date) {
		try {
			List<Schedule> rs = jdbcTemplate.query(
					"select * from schedule where start_date = ? or stop_date = ? order by id",
					new Object[] { date, date }, new BeanPropertyRowMapper<Schedule>(Schedule.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public Schedule insert(Schedule schedule) {

		final String INSERT_SQL = "insert into Schedule (medical_worker_id,start_date,start_time,stop_date,stop_time) values (?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt(1, schedule.getMedicalWorkerId());
				ps.setDate(2, schedule.getStartDate());
				ps.setTime(3, schedule.getStartTime());
				ps.setDate(4, schedule.getEndDate());
				ps.setTime(5, schedule.getStartTime());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		schedule.setId(key.intValue());
		return schedule;

	}

	@Override
	public void update(Schedule schedule) {
		final String UPDATE_SQL = "update schedule set medical_worker_Id = ?, start_date = ?, start_time = ?, stop_date = ?, stop_time = ? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setInt(1, schedule.getMedicalWorkerId());
				ps.setDate(2, schedule.getStartDate());
				ps.setTime(3, schedule.getStartTime());
				ps.setDate(4, schedule.getEndDate());
				ps.setTime(5, schedule.getStartTime());
				ps.setInt(6, schedule.getId());
				return ps;
			}
		});
	}

}
