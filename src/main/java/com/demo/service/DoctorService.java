package com.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.demo.mapper.DoctorMapper;
import com.demo.model.Doctor;
import com.demo.model.Patient;

@Service
public class DoctorService {
	private Logger LOGGER = LogManager.getLogger(DoctorService.class);
	DoctorMapper mapper;

	public DoctorService(DoctorMapper mapper) {
		this.mapper = mapper;
	}

	public List<Doctor> getAllDoctors() {
		LOGGER.traceEntry();
		List<Doctor> doctors = mapper.getAllDoctors();
		LOGGER.traceExit(doctors);
		return doctors;
	}

	public List<Patient> getDoctorPatients(Doctor doctor) {
		LOGGER.entry(doctor);
		int id = doctor.getUserId();
		List<Patient> patients = mapper.getDoctorPatients(id);
		LOGGER.traceExit(patients);
		return patients;
	}

	public List<Doctor> getAllDoctorAllPatients() {
		LOGGER.traceEntry();
		int doctorId = 0;
		List<Doctor> doctorPatients = mapper.getAllDoctorAllPatients(doctorId);
		LOGGER.traceExit(doctorPatients);
		return doctorPatients;
	}

	public List<Doctor> getDoctorsPatients(int doctorId) {
		LOGGER.traceEntry();
		List<Doctor> doctorPatients = mapper.getAllDoctorAllPatients(doctorId);
		LOGGER.traceExit(doctorPatients);
		return doctorPatients;
	}

}
