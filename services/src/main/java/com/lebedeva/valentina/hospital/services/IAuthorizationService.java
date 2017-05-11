package com.lebedeva.valentina.hospital.services;

import org.springframework.transaction.annotation.Transactional;

import com.lebedeva.valentina.hospital.datamodel.Authorization;

public interface IAuthorizationService {
	Authorization getById(Integer id);

	Authorization getByLogin(String login);

	@Transactional
	void save(Authorization authorization);

}
