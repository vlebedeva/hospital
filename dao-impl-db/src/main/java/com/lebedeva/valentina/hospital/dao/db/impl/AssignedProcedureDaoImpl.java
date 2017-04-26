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

import com.lebedeva.valentina.hospital.dao.api.IAssignedProcedureDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedProcedure;

@Repository
public class AssignedProcedureDaoImpl implements IAssignedProcedureDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public AssignedProcedure getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from assigned_procedure where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<AssignedProcedure>(AssignedProcedure.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedProcedure> getByMedicalWorkerId(Integer medicalWorkerId) {
		try {
			List<AssignedProcedure> rs = jdbcTemplate.query(
					"select * from assigned_procedure where medical_worker_id = ? ORDER BY id",
					new Object[] { medicalWorkerId },
					new BeanPropertyRowMapper<AssignedProcedure>(AssignedProcedure.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedProcedure> getByMedicalCardId(Integer medicalCardId) {
		try {
			List<AssignedProcedure> rs = jdbcTemplate.query(
					"select * from assigned_procedure where medical_card_id = ? ORDER BY id",
					new Object[] { medicalCardId },
					new BeanPropertyRowMapper<AssignedProcedure>(AssignedProcedure.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedProcedure> getAll() {
		List<AssignedProcedure> rs = jdbcTemplate.query("select * from assigned_procedure ORDER BY id",
				new BeanPropertyRowMapper<AssignedProcedure>(AssignedProcedure.class));
		return rs;
	}

	@Override
	public AssignedProcedure insert(AssignedProcedure assignedProcedure) {
		final String INSERT_SQL = "insert into assigned_procedure ( medical_card_id, procedure_id, assigned, annotation) values (?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt(1, assignedProcedure.getMedicalCardId());
				ps.setInt(2, assignedProcedure.getProcedureId());
				ps.setDate(3, assignedProcedure.getAssigned());
				ps.setString(4, assignedProcedure.getAnnotation());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		assignedProcedure.setId(key.intValue());
		return assignedProcedure;
	}

	@Override
	public void update(AssignedProcedure assignedProcedure) {
		final String UPDATE_SQL = "update assigned_procedure set medical_card_id=?, procedure_id=?, assigned=?, medical_worker_id=?, done=?, annotation=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setInt(1, assignedProcedure.getMedicalCardId());
				ps.setInt(2, assignedProcedure.getProcedureId());
				ps.setDate(3, assignedProcedure.getAssigned());
				ps.setInt(4, assignedProcedure.getMedicalWorkerId());
				ps.setTime(5, assignedProcedure.getDone());
				ps.setString(6, assignedProcedure.getAnnotation());
				ps.setInt(7, assignedProcedure.getId());
				return ps;
			}
		});
	}

}
