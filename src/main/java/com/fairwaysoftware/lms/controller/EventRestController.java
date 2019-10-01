package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.Application;
import com.fairwaysoftware.lms.service.EventService;
import com.fairwaysoftware.lms.service.domain.Event;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Application.BASE_PATH + "/events")
@AllArgsConstructor
public class EventRestController {

    private EventService service;

    @GetMapping
    public List<Event> get(@RequestParam("leagueId") Integer leagueId, @RequestParam("seasonId") Integer seasonId) {
        //TODO Security check
        return service.findByLeagueIdAndSeasonId(leagueId, seasonId);
    }

}
