package com.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

	PatientMapper mapper;

	public PatientController(PatientMapper mapper) {
		this.mapper = mapper;
	}

	@GetMapping("/all")
	public List<Patient> getAll() {
		return mapper.getAll();
	}
	
	@GetMapping("/id")
	public Patient getById(@RequestParam("id") int id) {
		return mapper.getById(id);
	}

}
