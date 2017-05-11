package com.lebedeva.valentina.hospital.dao.api;

import com.lebedeva.valentina.hospital.datamodel.Authorization;

public interface IAuthorizationDao {
	Authorization getById(Integer id);

	Authorization getByLogin(String login);

	Authorization insert(Authorization authorization);

	void update(Authorization authorization);

}
