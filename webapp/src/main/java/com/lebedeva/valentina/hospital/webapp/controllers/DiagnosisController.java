package com.lebedeva.valentina.hospital.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.lebedeva.valentina.hospital.datamodel.Diagnosis;
import com.lebedeva.valentina.hospital.services.IDiagnosisService;
import com.lebedeva.valentina.hospital.webapp.models.DiagnosisModel;
import com.lebedeva.valentina.hospital.webapp.models.IdModel;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosisController.class);

	@Inject
	private IDiagnosisService diagnosisService;

	private List<Diagnosis> all = new ArrayList<>();

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Diagnosis> allDiagnosis;
		allDiagnosis = diagnosisService.getAll();
		all.addAll(allDiagnosis);
		List<DiagnosisModel> convertedDiagnosis = new ArrayList<>();
		for (Diagnosis diagnosis : allDiagnosis) {
			convertedDiagnosis.add(entity2model(diagnosis));
		}
		LOGGER.info("get all Diagnosis");
		return new ResponseEntity<List<DiagnosisModel>>(convertedDiagnosis, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "id") Integer diagnosisIdParam) {
		Diagnosis diagnosis = diagnosisService.getById(diagnosisIdParam);
		DiagnosisModel diagnosisModel = entity2model(diagnosis);
		return new ResponseEntity<DiagnosisModel>(diagnosisModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createDiagnosis(@RequestBody DiagnosisModel diagnosisModel) {
		Diagnosis diagnosis = model2entity(diagnosisModel);
		diagnosisService.save(diagnosis);
		return new ResponseEntity<IdModel>(new IdModel(diagnosis.getId()), HttpStatus.CREATED);
	}

	private DiagnosisModel entity2model(Diagnosis diagnosis) {
		DiagnosisModel diagnosisModel = new DiagnosisModel();
		diagnosisModel.setName(diagnosis.getName());
		return diagnosisModel;
	}

	private Diagnosis model2entity(DiagnosisModel diagnosisModel) {
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setName(diagnosisModel.getName());
		return diagnosis;
	}

}
