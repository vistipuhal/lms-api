package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.Application;
import com.fairwaysoftware.lms.security.SecurityFacade;
import com.fairwaysoftware.lms.service.LeagueMemberService;
import com.fairwaysoftware.lms.service.LeagueService;
import com.fairwaysoftware.lms.service.domain.League;
import com.fairwaysoftware.lms.service.domain.LeagueMember;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Application.BASE_PATH + "/leagues")
@AllArgsConstructor
public class LeagueRestController {

    private LeagueService leagueService;
    private LeagueMemberService leagueMemberService;

    @GetMapping
    public List<League> get() {
        return leagueMemberService.findByUserId(SecurityFacade.getCurrentUserId()).stream()
                .map(LeagueMember::getLeague).collect(Collectors.toList());
    }

}
