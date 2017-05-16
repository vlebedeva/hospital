package com.lebedeva.valentina.hospital.webapp.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lebedeva.valentina.hospital.datamodel.MedicalWorker;
import com.lebedeva.valentina.hospital.services.IMedicalWorkerService;
import com.lebedeva.valentina.hospital.webapp.models.IdModel;
import com.lebedeva.valentina.hospital.webapp.models.MedicalWorkerModel;

@RestController
@RequestMapping("/medicalworkers")
public class MedicalWorkerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalWorkerController.class);
	
	@Inject
	private IMedicalWorkerService medicalWorkerService;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "id") Integer MedicalWorkerIdParam) {
		MedicalWorker medicalWorker = medicalWorkerService.getById(MedicalWorkerIdParam);
		MedicalWorkerModel medicalWorkerModel = entity2model(medicalWorker);
		return new ResponseEntity<MedicalWorkerModel>(medicalWorkerModel, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMedicalWorker(@PathVariable(value = "id") Integer medicalWorkerIdParam,
			@RequestBody MedicalWorkerModel medicalWorkerModel) {
		MedicalWorker medicalWorker = medicalWorkerService.getById(medicalWorkerIdParam);
		medicalWorker.setFullName(medicalWorkerModel.getFullName());
		medicalWorkerService.save(medicalWorker);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}


	private MedicalWorkerModel entity2model(MedicalWorker medicalWorker) {
		MedicalWorkerModel medicalWorkerModel = new MedicalWorkerModel();
		medicalWorkerModel.setFullName(medicalWorker.getFullName());
		medicalWorkerModel.setPosition(medicalWorker.getPosition());
		medicalWorkerModel.setSpecialization(medicalWorker.getSpecialization());
		medicalWorkerModel.setCategory(medicalWorker.getCategory());
		return medicalWorkerModel;
	}



}
