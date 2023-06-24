package com.project.ecommerceapp.ecommerceapp.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto
{
	private Long id;
	private String first_name;
	private String last_name;
	private String email;
	private String mobile_number;
}
