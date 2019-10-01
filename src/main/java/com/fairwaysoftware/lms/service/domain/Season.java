package com.fairwaysoftware.lms.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Season {

    private Integer seasonId;

    @NotNull
    private League league;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

}
