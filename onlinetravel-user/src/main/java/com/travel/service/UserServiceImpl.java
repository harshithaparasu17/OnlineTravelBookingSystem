package com.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.entity.User;
import com.travel.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public User insertUser(User user) throws Exception {
		User savedUser = userRepository.save(user); // Note : save() is already implemented by Spring Data JPA
		if (savedUser != null) {
			return savedUser;
		} else
			return null;
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		List<User> allUsers = userRepository.findAll(); // Note : same as save
		return allUsers;
	}

	@Override
	public User getUserByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		User outputUser = userRepository.getUserByUserName(userName);

		if (outputUser == null) {
			throw new EntityNotFoundException(userName + " not listed in the database");
		} else {
			return outputUser;
		}
	}

	

	@Override
	public String delete(int userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
		return "Deleted successfully";
		
	}

	@Override
	public User getUserByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
	return userRepository.getUserByUserId(userId);
	}

	@Override
	public List<User> getUsersBetweenIds(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUsersBetweenIds(range1, range2);
	}

	@Override
	public List<User> getUserByRole(String role) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------->> Inside Service Impl role"+role);
		return userRepository.getUserByRole(role);
	}

	@Override
	public List<User> FilterByRole(String role) throws Exception {
		// TODO Auto-generated method stub
		List<User> filterByRole=getAllUsers().stream().filter((profile)->profile.getRole().equals(role)).collect(Collectors.toList());
		return filterByRole;
	}

	


}
