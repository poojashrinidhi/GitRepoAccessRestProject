package com.remind.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author PoojaShankar
 */
@Entity
@Getter
@Setter
public class User extends AbstractEntity {

	private String firstName;
	private String surName;
	private String position;
	private String githubProfileUrl;
}
