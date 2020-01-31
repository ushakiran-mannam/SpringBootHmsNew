package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepo;

@Component
public class VehicleService {
	@Autowired VehicleRepo vehicleRepository;
	
	public void add(Vehicle vehicle)
	{
		vehicleRepository.save(vehicle);
	}

	
	
}
