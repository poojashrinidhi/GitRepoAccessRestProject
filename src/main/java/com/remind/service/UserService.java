package com.remind.service;

import java.util.List;
import java.util.UUID;

import com.remind.models.User;

/**
 * @author PoojaShankar
 */
public interface UserService {

	List<User> getAllUsers();

	void addUser(User user);

	void deleteUser(UUID id);

	void updateUser(UUID id, User user);

	User getUserByUuid(UUID id);

}
