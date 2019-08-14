package com.remind.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.remind.dto.RepositoryResponseDTO;
import com.remind.service.RepositoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GitRepositoryServiceImpl implements RepositoryService {

	private static final String USER_REPOSITORY_URL = "%s/users/%s/repos";

	@Value("${git.repository.url}")
	private String gitRepositoryUrl;

	@Value("${auth.token}")
	private String accessToken;

	@Autowired
	private RestTemplate restTemplate;

	public GitRepositoryServiceImpl() {
	}

	public GitRepositoryServiceImpl(String gitRepositoryUrl, String accessToken) {
		this.gitRepositoryUrl = gitRepositoryUrl;
		this.accessToken = accessToken;
	}

	@Override
	public List<RepositoryResponseDTO> getUserRepositories(String userId) {

		String userRepoUrl = String.format(USER_REPOSITORY_URL, gitRepositoryUrl, userId);
		String token = "token " + accessToken;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", token);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		try {
			ResponseEntity<List<RepositoryResponseDTO>> response = restTemplate.exchange(userRepoUrl, HttpMethod.GET,
					entity, new ParameterizedTypeReference<List<RepositoryResponseDTO>>() {
					});

			return response.getBody();
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				log.error("Service endpoint not found " + userRepoUrl, e);
				throw new RuntimeException("Failed to GET url " + userRepoUrl, e);
			}
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				String errorMsg = String.format(
						"Failed to authorize the url %s. Please refresh the authentication token and retry",
						userRepoUrl);
				log.error(errorMsg);
				throw new RuntimeException(errorMsg, e);
			}
		}

		return null;
	}

}
