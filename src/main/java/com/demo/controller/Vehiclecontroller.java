package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Vehicle;
import com.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class Vehiclecontroller {
	@Autowired VehicleService vehicleService;
	
	@PostMapping
	public void postVehicle(@RequestBody Vehicle vehicle)
	{
		vehicleService.add(vehicle);
	}
	

}
