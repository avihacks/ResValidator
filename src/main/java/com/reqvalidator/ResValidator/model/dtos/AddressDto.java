package com.reqvalidator.ResValidator.model.dtos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reqvalidator.ResValidator.model.Address;
import com.reqvalidator.ResValidator.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class AddressDto {
    private static final Logger logger = LoggerFactory.getLogger(AddressDto.class);

	@NotBlank(message = "The country is required.")
	private String country;
	
	@NotBlank(message = "The city is required.")
	private String city;
	
	@NotBlank(message = "The street is required.")
	private String street;
	
	@NotBlank(message = "The zipcode is required")
	@Pattern(regexp = "^\\d{1,5}$", flags = { Flag.CASE_INSENSITIVE, Flag.MULTILINE }, message = "The Zip code is invalid.")
	private String zipCode;
	
	
	private String state;
	public void printInfo() {
        logger.info("AddressDto info: country={}, city={}", country, city);
    }
	  public Address toAddress() {
	    return new Address()
	        .setCountry(country)
	        .setCity(city)
	        .setStreet(street)
	        .setZipCode(zipCode)
	        .setState(state);
	  }
	
	

}
