package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.service.domain.League;
import net.bytebuddy.utility.RandomString;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestLeagueService {

    @Autowired
    private LeagueService service;

    @Test
    public void findAll() {
        Assertions.assertThat(service.findAll()).isNotEmpty();
    }

    @Test
    @Transactional
    public void saveWithId() {
        League league = new League(255, RandomString.make());
        league = service.save(league);
    }

    @Test
    @Transactional
    public void saveWithoutId() {
        League league = new League(null, RandomString.make());
        league = service.save(league);
        Assertions.assertThat(league.getLeagueId()).isNotNull().isGreaterThan(999);
    }

}
