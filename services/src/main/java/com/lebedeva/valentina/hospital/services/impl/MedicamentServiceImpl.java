package com.lebedeva.valentina.hospital.services.impl;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lebedeva.valentina.hospital.dao.impl.db.IMedicamentDao;
import com.lebedeva.valentina.hospital.datamodel.Medicament;
import com.lebedeva.valentina.hospital.services.IMedicamentService;

@Service
public class MedicamentServiceImpl implements IMedicamentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicamentServiceImpl.class);

	@Inject
	private IMedicamentDao medicamentDao;

	@Override
	public Medicament getById(Integer id) {
		return medicamentDao.getById(id);
	}

	@Override
	public List<Medicament> getByDiagnosis(Integer diagnosisId) {
		return medicamentDao.getByDiagnosis(diagnosisId);
	}

	@Override
	public List<Medicament> getAll() {
		return medicamentDao.getAll();
	}

	@Override
	public void save(Medicament medicament) {
		if (medicament.getId() == null) {
			System.out.println("Insert new Medicament");
			medicamentDao.insert(medicament);
		} else {

			System.out.println("Update Medicament");
			medicamentDao.update(medicament);
		}
	}

	@Override
	public void saveMultiple(Medicament... medicamentArray) {

		for (Medicament medicament : medicamentArray) {
			save(medicament);
		}

	}
}
