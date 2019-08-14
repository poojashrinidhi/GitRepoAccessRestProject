package com.remind.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.remind.models.User;

/**
 * @author PoojaShankar
 */
public interface UserRepository extends CrudRepository<User, UUID> {

}
