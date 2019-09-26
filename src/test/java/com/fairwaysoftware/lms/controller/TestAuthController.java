package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.security.AuthRequest;
import com.fairwaysoftware.lms.security.AuthResponse;
import com.fairwaysoftware.lms.service.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAuthController {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testAuth() {
        ResponseEntity<AuthResponse> responseEntity = this.template.postForEntity("/api/auth", new AuthRequest("gary.golfer@gmail.com", "password"), AuthResponse.class);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + responseEntity.getBody().getToken());
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<User> responseEntityUser = this.template.exchange("/api/auth/currentUser", HttpMethod.GET, httpEntity, User.class);
        assertThat(responseEntityUser.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(responseEntityUser.getBody()).extracting(User::getPasswordHash).isNull();
        assertThat(responseEntityUser.getBody()).extracting(User::getEmail).isEqualTo("gary.golfer@gmail.com");
    }

}
