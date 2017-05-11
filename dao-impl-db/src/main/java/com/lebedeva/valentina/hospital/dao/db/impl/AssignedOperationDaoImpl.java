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

import com.lebedeva.valentina.hospital.dao.api.IAssignedOperationDao;
import com.lebedeva.valentina.hospital.datamodel.AssignedOperation;

@Repository
public class AssignedOperationDaoImpl implements IAssignedOperationDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public AssignedOperation getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from assigned_operation where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<AssignedOperation>(AssignedOperation.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AssignedOperation> getByMedicalCardId(Integer medicalCardId) {
		try {
			List<AssignedOperation> rs = jdbcTemplate.query(
					"select * from assigned_operation where medical_worker_id = ? ORDER BY id",
					new Object[] { medicalCardId },
					new BeanPropertyRowMapper<AssignedOperation>(AssignedOperation.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public AssignedOperation insert(AssignedOperation assignedOperation) {
		final String INSERT_SQL = "insert into assigned_operation ( medical_card_id, operation_id, assigned, annotation) values (?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt(1, assignedOperation.getMedicalCardId());
				ps.setInt(2, assignedOperation.getOperationId());
				ps.setDate(3, assignedOperation.getAssigned());
				ps.setString(4, assignedOperation.getAnnotation());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		assignedOperation.setId(key.intValue());
		return assignedOperation;
	}

	@Override
	public void update(AssignedOperation assignedOperation) {
		final String UPDATE_SQL = "update assigned_operation set medical_card_id=?,operation_id=?, assigned=?, medical_worker_id=?, done=?, annotation=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setInt(1, assignedOperation.getMedicalCardId());
				ps.setInt(2, assignedOperation.getOperationId());
				ps.setDate(3, assignedOperation.getAssigned());
				ps.setInt(4, assignedOperation.getMedicalWorkerId());
				ps.setTime(5, assignedOperation.getDone());
				ps.setString(6, assignedOperation.getAnnotation());
				ps.setInt(7, assignedOperation.getId());
				return ps;
			}
		});

	}

}
