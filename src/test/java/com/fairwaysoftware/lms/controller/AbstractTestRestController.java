package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.security.AuthRequest;
import com.fairwaysoftware.lms.security.AuthResponse;
import com.fairwaysoftware.lms.security.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractTestRestController {

    @Autowired
    protected TestRestTemplate restTemplate;

    private static final String TEST_EMAIL = "gary.golfer@gmail.com";
    private static final String TEST_PASSWORD = "password";

    private AuthResponse authResponse;

    protected HttpEntity getTestHttpEntity() {
        return this.getTestHttpEntity(null);
    }

    protected HttpEntity getTestHttpEntity(Object o) {
        if (this.authResponse == null) {
            this.authResponse = getTestAuthResponse();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, TokenHelper.AUTHORIZATION_HEADER_PREFIX + " " + authResponse.getToken());
        HttpEntity httpEntity = new HttpEntity(o, httpHeaders);
        return httpEntity;
    }

    private AuthResponse getTestAuthResponse() {
        ResponseEntity<AuthResponse> responseEntity = this.restTemplate.postForEntity("/api/auth", new AuthRequest(TEST_EMAIL, TEST_PASSWORD), AuthResponse.class);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        return responseEntity.getBody();
    }

}
