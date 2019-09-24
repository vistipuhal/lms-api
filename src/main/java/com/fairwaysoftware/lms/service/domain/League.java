package com.fairwaysoftware.lms.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class League {

    private Integer leagueId;

    @NotEmpty
    private String name;

}
