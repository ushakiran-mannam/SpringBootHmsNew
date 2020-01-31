package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.Constants.QueryConstants;
import com.demo.model.Patient;

@Mapper
public interface PatientMapper {

	@Select(QueryConstants.GET_ALL_PATIENTS)
	List<Patient> getAll();

	@Select(QueryConstants.GET_PATIENT)
	Patient getById(int id);

	@Update(QueryConstants.UPDATE_PATIENT)
	int updatePatient(Patient patient);
	
	@Update(QueryConstants.DELETE_PATIENT)
	int deletePatient(Patient patient);
	
	@Insert(QueryConstants.INSERT_USER_PATIENT)
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "pk_user_id")
	int insertUser(Patient patient);
	
	@Insert(QueryConstants.INSERT_PATIENT)
	int insertPatient(Patient patient);
	
	
	
//	@Insert("insert into t_user(username,email,password,fk_role_id) values(?,?,?,?)")
//	@Options()
//	int insertUser();
	
	}
