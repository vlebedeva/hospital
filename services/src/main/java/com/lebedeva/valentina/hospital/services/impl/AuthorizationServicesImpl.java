package com.lebedeva.valentina.hospital.services.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.api.IAuthorizationDao;
import com.lebedeva.valentina.hospital.datamodel.Authorization;
import com.lebedeva.valentina.hospital.services.IAuthorizationService;

@Service
public class AuthorizationServicesImpl implements IAuthorizationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationServicesImpl.class);

	@Inject
	private IAuthorizationDao authorizationDao;

	@Override
	public Authorization getById(Integer id) {
		return authorizationDao.getById(id);
	}

	@Override
	public Authorization getByLogin(String login) {
		return authorizationDao.getByLogin(login);
	}

	@Override
	public void save(Authorization authorization) {
		if (authorization.getId() == null) {
			System.out.println("Insert new Authorization");
			authorizationDao.insert(authorization);
		} else {

			System.out.println("Update Authorization");
			authorizationDao.update(authorization);
		}

	}

}
