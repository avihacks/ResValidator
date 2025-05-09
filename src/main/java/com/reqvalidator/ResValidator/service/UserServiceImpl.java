package com.reqvalidator.ResValidator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reqvalidator.ResValidator.model.Address;
import com.reqvalidator.ResValidator.model.User;
import com.reqvalidator.ResValidator.repo.AddressRepository;
import com.reqvalidator.ResValidator.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	
	
	
	public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
		super();
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}

	
	

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		Address address = addressRepository.save(user.getAddress());
		user.setAddress(address);
		return userRepository.save(user);
	}

	 @Override
	  public List<User> findAll() {
	    List<User> users = new ArrayList<>();
	    userRepository.findAll().forEach(users::add);

	    return users;
	  }

	  @Override
	  public Optional<User> findById(int id) {
	    return userRepository.findById(id);
	  }

}
