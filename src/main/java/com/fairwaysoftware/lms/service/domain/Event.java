package com.fairwaysoftware.lms.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

    private Integer eventId;

    @NotNull
    private League league;

    private Season season;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private LocalDate eventDate;

    @NotNull
    private LocalTime eventTime;

}
