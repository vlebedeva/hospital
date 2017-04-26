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

import com.lebedeva.valentina.hospital.dao.api.IDiagnosisDao;
import com.lebedeva.valentina.hospital.datamodel.Diagnosis;

@Repository
public class DiagnosisDaoImpl implements IDiagnosisDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Diagnosis get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from Diagnosis where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Diagnosis>(Diagnosis.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Diagnosis insert(Diagnosis diagnosis) {

		final String INSERT_SQL = "insert into Diagnosis (name) values(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, diagnosis.getName());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		diagnosis.setId(key.intValue());
		return diagnosis;

	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from diagnosis where id=" + id);
	}

	@Override
	public List<Diagnosis> getAll() {
		List<Diagnosis> rs = jdbcTemplate.query("select * from diagnosis ",
				new BeanPropertyRowMapper<Diagnosis>(Diagnosis.class));
		return rs;
	}

	@Override
	public void update(Diagnosis diagnosis) {
		final String UPDATE_SQL = "update diagnosis set name =? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, diagnosis.getName());
				ps.setInt(2, diagnosis.getId());

				return ps;
			}
		});
	}
}
