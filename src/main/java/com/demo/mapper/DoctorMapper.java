package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;

import com.demo.Constants.QueryConstants;
import com.demo.model.Doctor;
import com.demo.model.Patient;

@Mapper
public interface DoctorMapper {

	@Select(QueryConstants.GET_ALL_DOCTORS)
	List<Doctor> getAllDoctors();

	@Select(QueryConstants.GET_DOCTOR_PATIENTS)
	List<Patient> getDoctorPatients(int id);
	
	 @Select(QueryConstants.GET_ALL_DOCTORS_ALL_PATIENTS)
	    @Results(value = {
	            @Result(property="userId", column="userId"),
	            @Result(property="username", column="username"),
	            @Result(property="email", column="email"),
	            @Result(property="password", column="password"),
	            @Result(property="specialization", column="specialization"),
	            @Result(property="roleId", column="roleId"),
	            @Result(property="patients", javaType=List.class, column="userId",
	                    many=@Many(select="getDoctorPatients"))
	    })
	 List<Doctor> getAllDoctorAllPatients(int doctorId);

}
