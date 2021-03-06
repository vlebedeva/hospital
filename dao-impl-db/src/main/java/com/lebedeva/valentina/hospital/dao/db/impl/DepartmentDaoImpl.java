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

import com.lebedeva.valentina.hospital.dao.api.IDepartmentDao;
import com.lebedeva.valentina.hospital.datamodel.Department;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Department getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from department where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Department>(Department.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Department insert(Department department) {

		final String INSERT_SQL = "insert into department (name) values(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, department.getName());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		department.setId(key.intValue());
		return department;

	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from department where id=" + id);
	}

	@Override
	public List<Department> getAll() {
		List<Department> rs = jdbcTemplate.query("select * from department ORDER BY id",
				new BeanPropertyRowMapper<Department>(Department.class));
		return rs;
	}

	@Override
	public void update(Department department) {
		final String UPDATE_SQL = "update department set name =? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, department.getName());
				ps.setInt(2, department.getId());

				return ps;
			}
		});
	}

}
