package com.lebedeva.valentina.hospital.dao.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lebedeva.valentina.hospital.dao.api.IAuthorizationDao;
import com.lebedeva.valentina.hospital.datamodel.Authorization;

@Repository
public class AuthorizationDaoImpl implements IAuthorizationDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Authorization getById(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from authorization where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Authorization>(Authorization.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Authorization getByLogin(String login) {
		try {
			return jdbcTemplate.queryForObject("select * from authorization where login = ? ", new Object[] { login },
					new BeanPropertyRowMapper<Authorization>(Authorization.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Authorization insert(Authorization authorization) {
		final String INSERT_SQL = "insert into authorization (login,password) values(?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, authorization.getLogin());
				ps.setString(2, authorization.getPassword());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		authorization.setId(key.intValue());
		return authorization;
	}

	@Override
	public void update(Authorization authorization) {
		final String UPDATE_SQL = "update authorization set login =?, password = ? where id = ?";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, authorization.getLogin());
				ps.setString(2, authorization.getPassword());
				ps.setInt(3, authorization.getId());
				return ps;
			}
		});

	}

}
