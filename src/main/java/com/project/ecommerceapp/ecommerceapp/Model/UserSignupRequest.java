package com.project.ecommerceapp.ecommerceapp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {
	
	
	 @JsonProperty("first_name")
	    private String firstName;

	    @JsonProperty("last_name")
	    private String lastName;

	    @JsonProperty("email")
	    private String email;

	    @JsonProperty("number")
	    private String number;

	    @JsonProperty("password")
	    private String password;
	
}
