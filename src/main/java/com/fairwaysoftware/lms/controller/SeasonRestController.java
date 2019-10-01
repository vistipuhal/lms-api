package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.Application;
import com.fairwaysoftware.lms.service.SeasonService;
import com.fairwaysoftware.lms.service.domain.Season;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Application.BASE_PATH + "/seasons")
@AllArgsConstructor
public class SeasonRestController {

    private SeasonService service;

    @GetMapping
    public List<Season> get(@RequestParam("leagueId") Integer leagueId) {
        //TODO Security check
        return service.findByLeagueId(leagueId);
    }

}
