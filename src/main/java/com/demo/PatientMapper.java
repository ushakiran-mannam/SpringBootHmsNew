package com.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatientMapper {

	@Select("select * from t_patient")
	List<Patient> getAll();

	@Select("select * from t_patient where id=#{id}")
	Patient getById(int id);
}
