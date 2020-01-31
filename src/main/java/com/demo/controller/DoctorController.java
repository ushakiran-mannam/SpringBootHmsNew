package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Constants.StatusConstants;
import com.demo.filter.EntryFilter;
import com.demo.model.CustomResponse;
import com.demo.model.Doctor;
import com.demo.model.Patient;
import com.demo.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	private Logger LOGGER = LogManager.getLogger(DoctorController.class);
	@Autowired
	DoctorService doctorService;

	@GetMapping("/all")
	public CustomResponse<List<Doctor>> getAll() {
		LOGGER.traceEntry();
		CustomResponse<List<Doctor>> response = new CustomResponse<List<Doctor>>();
		List<Doctor> doctors = doctorService.getAllDoctors();
		response.setStatus(StatusConstants.OK);
		response.setData(doctors);
		LOGGER.traceExit(doctors);
		return response;
	}

	@GetMapping("/getparticularpatients")
	public CustomResponse<List<Patient>> getDoctorPatients(@RequestBody Doctor doctor) {
		LOGGER.traceEntry();
		CustomResponse<List<Patient>> response = new CustomResponse<List<Patient>>();
		List<Patient> patients = doctorService.getDoctorPatients(doctor);
		response.setStatus(StatusConstants.OK);
		response.setData(patients);
		LOGGER.traceExit(patients);
		return response;
	}

	@GetMapping("/{doctorId}/getallpatients")
	public CustomResponse<List<Doctor>> getDoctorPatients(@PathVariable("doctorId") Integer doctorId) {
		LOGGER.entry(doctorId);
		if (doctorId == null) {
			doctorId = 0;
		}
		CustomResponse<List<Doctor>> response = new CustomResponse<List<Doctor>>();
		List<Doctor> doctorPatients = doctorService.getDoctorsPatients(doctorId);
		response.setStatus(StatusConstants.OK);
		response.setData(doctorPatients);
		LOGGER.traceExit(doctorPatients);
		return response;

	}

	@GetMapping("/getallpatients")
	public CustomResponse<List<Doctor>> getAllDoctorAllPatients(@RequestAttribute("requestId") int requestId ) {
		LOGGER.traceEntry();
		CustomResponse<List<Doctor>> response = new CustomResponse<List<Doctor>>();
		List<Doctor> doctorPatients = doctorService.getAllDoctorAllPatients();
		response.setStatus(StatusConstants.OK);
		response.setData(doctorPatients);
		
		response.setRequestId(requestId);
		LOGGER.traceExit(doctorPatients);
		return response;

	}

}
