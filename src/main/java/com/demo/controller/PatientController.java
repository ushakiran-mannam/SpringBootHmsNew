package com.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Constants.StatusConstants;
import com.demo.model.CustomResponse;
import com.demo.model.Patient;
import com.demo.service.PatientService;
@CrossOrigin
@RestController
@RequestMapping("/patients")
public class PatientController {
	private Logger LOGGER = LogManager.getLogger(PatientController.class);
	@Autowired
	PatientService patientService;

	@GetMapping("/all")
	public CustomResponse<List<Patient>> getAll() {
		LOGGER.traceEntry();
		CustomResponse<List<Patient>> response = new CustomResponse<List<Patient>>();
		List<Patient> patients = patientService.getAllPatients();
		response.setStatus(StatusConstants.OK);
		response.setData(patients);
		LOGGER.traceExit(patients);
		return response;
	}

	@GetMapping("/id")
	public CustomResponse<Patient> getById(@RequestBody Patient patient) {
		LOGGER.entry(patient);
		CustomResponse<Patient> response = new CustomResponse<Patient>();
		Patient patientRecord = patientService.getPatient(patient);
		response.setStatus(StatusConstants.OK);
		response.setData(patientRecord);
		LOGGER.traceExit(patientRecord);
		return response;
	}

	@PostMapping("/update")
	public CustomResponse<String> updatePatient(@RequestBody Patient patient) {
		LOGGER.entry(patient);
		CustomResponse<String> response = new CustomResponse<String>();
		int updated = patientService.updatePatient(patient);
		response.setStatus(StatusConstants.OK);
		response.setData(updated + " no of records updated succesfully");
		LOGGER.traceExit(updated + " no of records");
		return response;
	}
	@PutMapping("/delete")
	public CustomResponse<String> deletePatient(@RequestBody Patient patient) {
		LOGGER.entry(patient);
		CustomResponse<String> response = new CustomResponse<String>();
		int deleted = patientService.deletePatient(patient);
		response.setStatus(StatusConstants.OK);
		response.setData(deleted + " no of records deleted succesfully");
		LOGGER.traceExit(deleted + " no of records");
		return response;
	}
	@PostMapping("/create")
	public CustomResponse<Patient> createPatient(@RequestBody Patient patient) {
		LOGGER.entry(patient);
		CustomResponse<Patient> response = new CustomResponse<Patient>();
		Patient createdPatient = patientService.createPatient(patient);
		if(createdPatient!=null)
		{
		response.setStatus(StatusConstants.OK);
		response.setData(createdPatient);
		LOGGER.traceExit(createdPatient);
		return response;
		}
		else
		{
			response.setStatus(StatusConstants.ERROR);
			response.setData(null);
			LOGGER.traceExit(null);
			return response;
		}
	}

}
