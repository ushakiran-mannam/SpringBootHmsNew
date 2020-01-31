package com.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.demo.mapper.PatientMapper;
import com.demo.model.Patient;

@Service
public class PatientService {
	private Logger LOGGER = LogManager.getLogger(PatientService.class);

	PatientMapper mapper;

	public PatientService(PatientMapper mapper) {
		this.mapper = mapper;
	}

	public List<Patient> getAllPatients() {
		LOGGER.traceEntry();
		List<Patient> patients = mapper.getAll();
		LOGGER.traceExit(patients);
		return patients;
	}

	public Patient getPatient(Patient patient) {
		LOGGER.entry(patient);
		int patientId = patient.getUserId();
		Patient patientRecord = mapper.getById(patientId);
		LOGGER.traceExit(patientRecord);
		return patientRecord;
	}

	public int updatePatient(Patient patient) {
		LOGGER.entry(patient);
		int updated = mapper.updatePatient(patient);
		LOGGER.traceExit(updated);
		return updated;
	}

	public int deletePatient(Patient patient) {
		LOGGER.entry(patient);
		int deleted = mapper.deletePatient(patient);
		LOGGER.traceExit(deleted);
		return deleted;
	}

	public Patient createPatient(Patient patient) {
		LOGGER.entry(patient);
		mapper.insertUser(patient);
		int inserted = mapper.insertPatient(patient);
		if(inserted!=0)
		{
			return patient;
		}
		LOGGER.traceExit(inserted);
		return null;
	}
}
