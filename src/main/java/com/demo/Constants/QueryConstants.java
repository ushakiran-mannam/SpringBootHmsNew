package com.demo.Constants;

public class QueryConstants {

	public static final String GET_ALL_DOCTORS = "select pk_user_id as userId,username,email,password,fk_role_id  as roleId,specialist as specialization from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.is_active=1 and t_doctor.is_active=1";
	public static final String GET_ALL_PATIENTS = "select pk_user_id as userId,username,email,password,fk_role_id as roleId,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where t_user.is_active =1 and t_patient.is_active=1";
	public static final String GET_PATIENT = "select pk_user_id as userId,username,email,password,fk_role_id as roleId,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where  t_user.pk_user_id=#{id} and   t_user.is_active =1 and t_patient.is_active=1";
	public static final String UPDATE_PATIENT = "update t_patient set age=#{age},area=#{area},city=#{city},state=#{state} where fk_user_id=#{userId} and is_active=1";
	public static final String DELETE_PATIENT = "update t_patient set is_active=0 where fk_user_id=#{userId}";
	public static final String INSERT_USER_PATIENT = "insert into t_user(username,email,password,fk_role_id) values(#{username},#{email},#{password},1)";
	public static final String INSERT_USER_DOCTOR = "insert into t_user(username,email,password,fk_role_id) values(#{username},#{email},#{password},2)";
	public static final String INSERT_PATIENT = "insert into t_patient(age,area,city,state,fk_user_id) values(#{age},#{area},#{city},#{state},#{id})";
	public static final String GET_DOCTOR_PATIENTS = "select t_patient_has_doctor.fk_doctor_id, pk_user_id as userId,username,email,password,fk_role_id as roleId,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id join t_patient_has_doctor on t_patient_has_doctor.fk_patient_id = t_user.pk_user_id  where t_patient_has_doctor.fk_doctor_id = #{id} and t_user.is_active =1 and t_patient.is_active=1 and  t_patient_has_doctor.is_active=1";
	public static final String GET_ALL_DOCTORS_ALL_PATIENTS = "<script> select pk_user_id as userId,username,email,password,fk_role_id as roleId,specialist as specialization from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id where <if test='doctorId!=0'> t_doctor.fk_user_id = #{doctorId} and </if> t_user.is_active=1 and t_doctor.is_active=1</script>";
	

}
