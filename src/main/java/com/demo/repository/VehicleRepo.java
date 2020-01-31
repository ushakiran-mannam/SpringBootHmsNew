package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.Vehicle;

public interface VehicleRepo extends CrudRepository<Vehicle,Long>{

}
