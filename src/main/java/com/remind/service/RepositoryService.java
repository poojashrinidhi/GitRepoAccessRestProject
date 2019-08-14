package com.remind.service;

import java.util.List;

import com.remind.dto.RepositoryResponseDTO;

/**
 * @author PoojaShankar
 */
public interface RepositoryService {

	List<RepositoryResponseDTO> getUserRepositories(String id);
}
