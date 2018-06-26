package com.aoao.simpleCrm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Employee implements Serializable {
	private int emp_id;
	private int role_id;
	private String emp_name;
	private String emp_loginname;
	private String emp_password;
	private String emp_gender;
	private String emp_telphone;
	private String emp_email;
	private String emp_address;
	private Date emp_birthday;
	private Date create_time;
	private String db_source;
	
	
}
