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

import com.lebedeva.valentina.hospital.dao.api.IMedicamentDao;
import com.lebedeva.valentina.hospital.datamodel.Medicament;

@Repository
public class MedicamentDaoImpl implements IMedicamentDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Medicament getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from medicament where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Medicament>(Medicament.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Medicament> getByDiagnosis(Integer diagnosisId) {
		List<Medicament> rs = jdbcTemplate.query("select * from medicament where diagnosis_id = ? order by id",
				new Object[] { diagnosisId }, new BeanPropertyRowMapper<Medicament>(Medicament.class));
		return rs;
	}

	@Override
	public List<Medicament> getAll() {
		List<Medicament> rs = jdbcTemplate.query("select * from medicament order by id",
				new BeanPropertyRowMapper<Medicament>(Medicament.class));
		return rs;
	}

	@Override
	public Medicament insert(Medicament medicament) {

		final String INSERT_SQL = "insert into medicament (name, diagnosis_id) values(?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, medicament.getName());
				ps.setInt(2, medicament.getDiagnosisId());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		medicament.setId(key.intValue());
		return medicament;

	}

	@Override
	public void update(Medicament medicament) {
		final String UPDATE_SQL = "update medicament set name =?, diagnosis_id=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, medicament.getName());
				ps.setInt(2, medicament.getDiagnosisId());
				ps.setInt(3, medicament.getId());

				return ps;
			}
		});
	}

}
