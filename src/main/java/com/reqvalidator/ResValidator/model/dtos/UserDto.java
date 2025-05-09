package com.reqvalidator.ResValidator.model.dtos;


import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reqvalidator.ResValidator.model.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data // ✅ Add this!
public class UserDto {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @JsonProperty("name")
	@NotEmpty(message = "The full name is required.")
	@Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
	private String name;
	
	@NotEmpty(message = "The email is required.")
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;
	
	@Past(message = "The date of birth must be in the past.")
	@NotNull(message = "Date of birth is required")
	@JsonProperty("dateOfBirth")
	private LocalDate dateofBirth;
	
	@NotEmpty(message = "The gender is required.")
	private String gender;
	
	@Valid
	private AddressDto address;
	
	public void printInfo() {
        logger.info("User info: name={}, email={}", name, email);
        address.printInfo();
    }
	 public User toUser() {
		 if (email == null) {
		        logger.error("Email is null. Cannot convert to User.");
		        throw new IllegalArgumentException("Email cannot be null.");
		    }
		    return new User()
		        .setName(name)
		        .setEmail(email.toLowerCase())
		        .setBirthDate(dateofBirth)
		        .setGender(gender)
		        .setAddress(address.toAddress());
		  }

}
