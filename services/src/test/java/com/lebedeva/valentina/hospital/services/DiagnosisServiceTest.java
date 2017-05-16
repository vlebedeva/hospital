package com.lebedeva.valentina.hospital.services;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.lebedeva.valentina.hospital.datamodel.Diagnosis;

public class DiagnosisServiceTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosisServiceTest.class);

	private Diagnosis diagnosis;
	private Integer savedDiagnosisId;
	private String name = "diagnosis from test";

	@Inject
	private IDiagnosisService service;

	@Before
	public void createTestObject() {
		diagnosis = new Diagnosis();
		diagnosis.setName(name);
	}

	// CREATE
	@Test
	public void createDiagnosisTest() {
		LOGGER.info("---------Create Diagnosis Test---------");
		service.save(diagnosis);
		LOGGER.info("---------Saved New Diagnosis ---------");
		Integer savedDiagnosisId = diagnosis.getId();
		Diagnosis diagnosisFromDB = service.getById(savedDiagnosisId);
		Assert.notNull(diagnosisFromDB, "Diagnosis must be saved");
	}

	// READ
	@Test
	public void readDiagnosisTest() {
		LOGGER.info("---------Read Diagnosis Test---------");
		service.save(diagnosis);
		LOGGER.info("---------Saved New Diagnosis ---------");
		savedDiagnosisId = diagnosis.getId();
		Diagnosis diagnosisFromDB = service.getById(savedDiagnosisId);
		Assert.notNull(diagnosisFromDB, "Diagnosis must be saved");
		Assert.isTrue(service.getById(savedDiagnosisId).getId().equals(diagnosisFromDB.getId()),
				"Can't read created Diagnosis");
		LOGGER.info("Diagnosis with id {} was succesfully read", diagnosisFromDB.getId());

	}

	// READ ALL
	@Test
	public void readAllDiagnosisTest() {
		LOGGER.info("---------Read All Diagnosis Test---------");
		service.save(diagnosis);
		Integer size = 0;
		Assert.notNull(size = service.getAll().size(), "Can't get list of Diagnosis from DB");
		LOGGER.info("Size of Diagnosis is {} ", size);
		diagnosis.setId(null);
		diagnosis.setName("add from readAll test");
		service.save(diagnosis);
		Assert.isTrue(size + 1 == service.getAll().size(), "Can't get list of Diagnosis from DB");
		LOGGER.info("Size of Diagnosis is {} ", size + 1);
	}

	
}
