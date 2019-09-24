package com.fairwaysoftware.lms.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeagueMember {

    private Integer leagueMemberId;

    @NotNull
    private League league;

    @NotNull
    private UserProfile userProfile;

}
