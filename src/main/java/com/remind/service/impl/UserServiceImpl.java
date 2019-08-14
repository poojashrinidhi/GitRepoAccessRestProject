package com.remind.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remind.models.User;
import com.remind.repository.UserRepository;
import com.remind.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User getUserByUuid(UUID id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(UUID id, User user) {
		user.setId(id);
		userRepository.save(user);
	}

	@Override
	public void deleteUser(UUID id) {
		userRepository.deleteById(id);
	}

}
