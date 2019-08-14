package com.remind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remind.dto.RepositoryResponseDTO;
import com.remind.service.RepositoryService;

/**
 * @author PoojaShankar
 */
@RestController
public class GitRepositoryController {

	@Autowired
	RepositoryService repositoryService;

	@RequestMapping("/users/{id}/repositories")
	public List<RepositoryResponseDTO> getUserGitRepositories(@PathVariable String id) {
		return repositoryService.getUserRepositories(id);
	}

}
