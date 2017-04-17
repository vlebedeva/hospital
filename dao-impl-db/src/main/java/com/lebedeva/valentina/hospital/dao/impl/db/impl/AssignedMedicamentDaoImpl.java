package com.lebedeva.valentina.hospital.dao.impl.db.impl;

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

import com.lebedeva.valentina.hospital.dao.impl.db.IAssignedMedicamentDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedMedicament;

@Repository
public class AssignedMedicamentDaoImpl implements IAssignedMedicamentDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public AssignedMedicament getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from assigned_medicament where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<AssignedMedicament>(AssignedMedicament.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedMedicament> getByMedicalWorkerId(Integer medicalWorkerId) {
		try {
			List<AssignedMedicament> rs = jdbcTemplate.query(
					"select * from assigned_medicament where medical_worker_id = ? ORDER BY id",
					new Object[] { medicalWorkerId },
					new BeanPropertyRowMapper<AssignedMedicament>(AssignedMedicament.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedMedicament> getByMedicalCardId(Integer medicalCardId) {
		try {
			List<AssignedMedicament> rs = jdbcTemplate.query(
					"select * from assigned_medicament where medical_card_id = ? ORDER BY id",
					new Object[] { medicalCardId },
					new BeanPropertyRowMapper<AssignedMedicament>(AssignedMedicament.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedMedicament> getAll() {
		List<AssignedMedicament> rs = jdbcTemplate.query("select * from assigned_medicament ORDER BY id",
				new BeanPropertyRowMapper<AssignedMedicament>(AssignedMedicament.class));
		return rs;
	}

	@Override
	public AssignedMedicament insert(AssignedMedicament assignedMedicament) {
		final String INSERT_SQL = "insert into assigned_medicament ( medical_card_id, medicament_id, assigned, annotation) values (?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt(1, assignedMedicament.getMedicalCardId());
				ps.setInt(2, assignedMedicament.getMedicamentId());
				ps.setDate(3, assignedMedicament.getAssigned());
				ps.setString(4, assignedMedicament.getAnnotation());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		assignedMedicament.setId(key.intValue());
		return assignedMedicament;
	}

	@Override
	public void update(AssignedMedicament assignedMedicament) {
		final String UPDATE_SQL = "update assigned_medicament set medical_card_id=?, medicament_id=?, assigned=?, medical_worker_id=?, done=?, annotation=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setInt(1, assignedMedicament.getMedicalCardId());
				ps.setInt(2, assignedMedicament.getMedicamentId());
				ps.setDate(3, assignedMedicament.getAssigned());
				ps.setInt(4, assignedMedicament.getMedicalWorkerId());
				ps.setTime(5, assignedMedicament.getDone());
				ps.setString(6, assignedMedicament.getAnnotation());
				ps.setInt(7, assignedMedicament.getId());
				return ps;
			}
		});

	}

}
