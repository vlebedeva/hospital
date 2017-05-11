package com.lebedeva.valentina.hospital.dao.db.impl;

import java.sql.Connection;
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

import com.lebedeva.valentina.hospital.dao.api.IMedicalWorkerDao;
import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.datamodel.Position;

@Repository
public class MedicalWorkerDaoImpl implements IMedicalWorkerDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public MedicalWorker getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from medical_worker where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<MedicalWorker>(MedicalWorker.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<MedicalWorker> getByPosition(Position position) {
		try {
			List<MedicalWorker> rs = jdbcTemplate.query("select * from medical_worker where position = ? ORDER BY id",
					new Object[] { position.toString() },
					new BeanPropertyRowMapper<MedicalWorker>(MedicalWorker.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<MedicalWorker> getByActive(Boolean active) {
		try {
			List<MedicalWorker> rs = jdbcTemplate.query("select * from medical_worker where active = ? ORDER BY id",
					new Object[] { active }, new BeanPropertyRowMapper<MedicalWorker>(MedicalWorker.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public MedicalWorker insert(MedicalWorker medicalWorker) {

		final String INSERT_SQL = "insert into medical_worker ( full_name, position, specialization, category, department_id, active, login) values (?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, medicalWorker.getFullName());
				ps.setString(2, medicalWorker.getPosition().toString());
				ps.setString(3, medicalWorker.getSpecialization());
				ps.setString(4, medicalWorker.getCategory().toString());
				ps.setInt(5, medicalWorker.getDepartmentId());
				ps.setBoolean(6, medicalWorker.getActive());
				ps.setString(7, medicalWorker.getLogin());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		medicalWorker.setId(key.intValue());
		return medicalWorker;

	}

	@Override
	public void update(MedicalWorker medicalWorker) {
		final String UPDATE_SQL = "update medical_worker set full_name =?, position=?, specialization=?, category=?, department_id=?, active=?, login=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, medicalWorker.getFullName());
				ps.setString(2, medicalWorker.getPosition().toString());
				ps.setString(3, medicalWorker.getSpecialization());
				ps.setString(4, medicalWorker.getCategory().toString());
				ps.setInt(5, medicalWorker.getDepartmentId());
				ps.setBoolean(6, medicalWorker.getActive());
				ps.setString(7, medicalWorker.getLogin());
				ps.setInt(8, medicalWorker.getId());
				return ps;
			}
		});
	}

}
