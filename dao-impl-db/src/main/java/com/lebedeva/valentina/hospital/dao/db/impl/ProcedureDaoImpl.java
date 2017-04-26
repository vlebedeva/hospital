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

import com.lebedeva.valentina.hospital.dao.api.IProcedureDao;
import com.lebedeva.valentina.hospital.datamodel.Procedure;

@Repository
public class ProcedureDaoImpl implements IProcedureDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Procedure getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from procedure where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Procedure>(Procedure.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Procedure> getByDiagnosis(Integer diagnosisId) {
		List<Procedure> rs = jdbcTemplate.query("select * from procedure where diagnosis_id = ? order by id",
				new Object[] { diagnosisId }, new BeanPropertyRowMapper<Procedure>(Procedure.class));
		return rs;
	}

	@Override
	public List<Procedure> getAll() {
		List<Procedure> rs = jdbcTemplate.query("select * from procedure order by id",
				new BeanPropertyRowMapper<Procedure>(Procedure.class));
		return rs;
	}

	@Override
	public Procedure insert(Procedure procedure) {

		final String INSERT_SQL = "insert into procedure (name, diagnosis_id) values(?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, procedure.getName());
				ps.setInt(2, procedure.getDiagnosisId());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		procedure.setId(key.intValue());
		return procedure;

	}

	@Override
	public void update(Procedure procedure) {
		final String UPDATE_SQL = "update procedure set name =?, diagnosis_id=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, procedure.getName());
				ps.setInt(2, procedure.getDiagnosisId());
				ps.setInt(3, procedure.getId());

				return ps;
			}
		});
	}
}
