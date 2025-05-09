package com.reqvalidator.ResValidator.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reqvalidator.ResValidator.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer>{

}