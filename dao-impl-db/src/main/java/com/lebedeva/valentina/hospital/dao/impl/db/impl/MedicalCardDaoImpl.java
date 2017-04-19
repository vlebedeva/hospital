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

import com.lebedeva.valentina.hospital.dao.impl.db.IMedicalCardDao;
import com.lebedeva.valentina.hospital.datamodel.MedicalCard;

@Repository
public class MedicalCardDaoImpl implements IMedicalCardDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public MedicalCard getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from medical_card where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<MedicalCard>(MedicalCard.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<MedicalCard> getAll() {
		List<MedicalCard> rs = jdbcTemplate.query("select * from medical_card ORDER BY id",
				new BeanPropertyRowMapper<MedicalCard>(MedicalCard.class));
		return rs;
	}

	@Override
	public List<MedicalCard> getByDepartmentId(Integer departmentId) {
		try {
			List<MedicalCard> rs = jdbcTemplate.query("select * from medical_card where department_id = ? ORDER BY id",
					new Object[] { departmentId }, new BeanPropertyRowMapper<MedicalCard>(MedicalCard.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<MedicalCard> getByDoctorId(Integer medicalWorkerId) {
		try {
			List<MedicalCard> rs = jdbcTemplate.query(
					"select * from medical_card  where medical_worker_id = ?  ORDER BY id",
					new Object[] { medicalWorkerId }, new BeanPropertyRowMapper<MedicalCard>(MedicalCard.class));
			return rs;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public MedicalCard insert(MedicalCard medicalCard) {
		final String INSERT_SQL = "insert into medical_card ( patient_full_name, birthday, adress,document,phone_number,diagnosis_id,medical_worker_id,department_id,enter_date,discharge_date) values (?,?,?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, medicalCard.getPatientFullName());
				ps.setDate(2, medicalCard.getBirthday());
				ps.setString(3, medicalCard.getAdress());
				ps.setString(4, medicalCard.getDocument());
				ps.setString(5, medicalCard.getPhoneNumber());
				ps.setInt(6, medicalCard.getDiagnosisId());
				ps.setInt(7, medicalCard.getMedicalWorkerId());
				ps.setInt(8, medicalCard.getDepartmentId());
				ps.setDate(9, medicalCard.getEnterDate());
				ps.setDate(10, medicalCard.getDischargeDate());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		medicalCard.setId(key.intValue());
		return medicalCard;
	}

	@Override
	public void update(MedicalCard medicalCard) {
		final String UPDATE_SQL = "update medical_card set patient_full_name=?, birthday=?, adress=?,document=?,phone_number=?,diagnosis_id=?,medical_worker_id=?,department_id=?,enter_date=?,discharge_date=? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, medicalCard.getPatientFullName());
				ps.setDate(2, medicalCard.getBirthday());
				ps.setString(3, medicalCard.getAdress());
				ps.setString(4, medicalCard.getDocument());
				ps.setString(5, medicalCard.getPhoneNumber());
				ps.setInt(6, medicalCard.getDiagnosisId());
				ps.setInt(7, medicalCard.getMedicalWorkerId());
				ps.setInt(8, medicalCard.getDepartmentId());
				ps.setDate(9, medicalCard.getEnterDate());
				ps.setDate(10, medicalCard.getDischargeDate());
				ps.setInt(11, medicalCard.getId());
				return ps;
			}
		});

	}

}
