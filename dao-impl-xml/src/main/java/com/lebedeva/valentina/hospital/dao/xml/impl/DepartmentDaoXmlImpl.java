package com.lebedeva.valentina.hospital.dao.xml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.lebedeva.valentina.hospital.dao.api.IDepartmentDao;
import com.lebedeva.valentina.hospital.dao.xml.impl.exception.NotSupportedMethodException;
import com.lebedeva.valentina.hospital.dao.xml.impl.wrapper.XmlModelWrapper;
import com.lebedeva.valentina.hospital.datamodel.Department;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class DepartmentDaoXmlImpl implements IDepartmentDao {

	private final XStream xstream = new XStream(new DomDriver());

	@Value("${root.folder}")
	private String rootFolder;

	@Override
	public Department getById(Integer id) {
		File file = getFile();

		XmlModelWrapper<Integer, Department> wrapper = (XmlModelWrapper<Integer, Department>) xstream.fromXML(file);
		List<Department> departments = wrapper.getRows();
		for (Department department : departments) {
			if (department.getId().equals(id)) {
				return department;
			}
		}
		return null;
	}

	@Override
	public Department insert(Department department) {
		File file = getFile();

		XmlModelWrapper<Integer, Department> wrapper = (XmlModelWrapper<Integer, Department>) xstream.fromXML(file);
		List<Department> departments = wrapper.getRows();
		Integer lastId = wrapper.getLastId();
		int newId = lastId + 1;

		department.setId(newId);
		departments.add(department);

		wrapper.setLastId(newId);
		writeNewData(file, wrapper);
		return department;
	}

	@Override
	public void update(Department department) {
		File file = getFile();

		XmlModelWrapper<Integer, Department> wrapper = (XmlModelWrapper<Integer, Department>) xstream.fromXML(file);
		List<Department> departments = wrapper.getRows();
		for (Department departmentItem : departments) {
			if (departmentItem.getId().equals(department.getId())) {
				// TODO copy all properties
				break;
			}
		}

		writeNewData(file, wrapper);

	}

	@Override
	public List<Department> getAll() {
		File file = getFile();

		XmlModelWrapper<Integer, Department> wrapper = (XmlModelWrapper<Integer, Department>) xstream.fromXML(file);
		return wrapper.getRows();
	}

	private void writeNewData(File file, XmlModelWrapper obj) {
		try {
			xstream.toXML(obj, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Integer id) {
		File file = getFile();

		XmlModelWrapper<Integer, Department> wrapper = (XmlModelWrapper<Integer, Department>) xstream.fromXML(file);
		List<Department> departments = wrapper.getRows();
		Department found = null;
		for (Department department : departments) {
			if (department.getId().equals(id)) {
				found = department;
				break;
			}
		}
		if (found != null) {
			departments.remove(found);
			writeNewData(file, wrapper);
		}

	}

	private File getFile() {
		File file = new File(rootFolder + "departments.xml");
		return file;
	}

}
