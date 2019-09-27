package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.security.AuthRequest;
import com.fairwaysoftware.lms.service.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAuthController extends AbstractTestRestController {

    @Test
    public void auth() {
        HttpEntity httpEntity = this.getTestHttpEntity();
        ResponseEntity<User> responseEntityUser = restTemplate.exchange("/api/auth/currentUser", HttpMethod.GET, httpEntity, User.class);
        assertThat(responseEntityUser.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(responseEntityUser.getBody()).extracting(User::getPasswordHash).isNull();
        assertThat(responseEntityUser.getBody()).extracting(User::getEmail).isEqualTo("gary.golfer@gmail.com");
    }

    @Test
    public void unauthorized() {
        HttpEntity httpEntity = new HttpEntity<>(new AuthRequest("blah", "badpass"));
        ResponseEntity<String> responseEntity = restTemplate.exchange("/api/auth", HttpMethod.POST, httpEntity, String.class);
        assertThat(responseEntity.getStatusCode().is4xxClientError()).isTrue();
    }

}
