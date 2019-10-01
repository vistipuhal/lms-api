package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.Application;
import com.fairwaysoftware.lms.service.LeagueMemberService;
import com.fairwaysoftware.lms.service.LeagueService;
import com.fairwaysoftware.lms.service.domain.LeagueMember;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Application.BASE_PATH + "/leagueMembers")
@AllArgsConstructor
public class LeagueMemberRestController {

    private LeagueService leagueService;
    private LeagueMemberService leagueMemberService;

    @GetMapping
    public List<LeagueMember> get(@RequestParam("leagueId") Integer leagueId) {
        //TODO Security Check for if league member or league admin
        return leagueMemberService.findByLeagueId(leagueId);
    }

}
