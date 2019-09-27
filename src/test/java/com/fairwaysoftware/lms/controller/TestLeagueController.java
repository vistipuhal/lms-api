package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.service.domain.League;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestLeagueController extends AbstractTestRestController {

    @Test
    public void get() {
        ResponseEntity<League[]> responseEntity = restTemplate.exchange("/api/leagues", HttpMethod.GET, getTestHttpEntity(), League[].class);
        assertThat(responseEntity.getBody().length).isEqualTo(1);
    }

}
