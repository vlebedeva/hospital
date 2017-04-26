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

import com.lebedeva.valentina.hospital.dao.api.IOperationDao;
import com.lebedeva.valentina.hospital.datamodel.Operation;

@Repository
public class OperationDaoImpl implements IOperationDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Operation getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from operation where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Operation>(Operation.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Operation> getByDiagnosis(Integer diagnosisId) {
		List<Operation> rs = jdbcTemplate.query("select * from operation where diagnosis_id = ? order by id",
				new Object[] { diagnosisId }, new BeanPropertyRowMapper<Operation>(Operation.class));
		return rs;
	}

	@Override
	public List<Operation> getAll() {
		List<Operation> rs = jdbcTemplate.query("select * from operation order by id",
				new BeanPropertyRowMapper<Operation>(Operation.class));
		return rs;
	}

	@Override
	public Operation insert(Operation operation) {

		final String INSERT_SQL = "insert into operation (name, diagnosis_id) values(?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, operation.getName());
				ps.setInt(2, operation.getDiagnosisId());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		operation.setId(key.intValue());
		return operation;

	}

	@Override
	public void update(Operation operation) {
		final String UPDATE_SQL = "update operation set name =?, diagnosis_id=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, operation.getName());
				ps.setInt(2, operation.getDiagnosisId());
				ps.setInt(3, operation.getId());

				return ps;
			}
		});
	}

}
