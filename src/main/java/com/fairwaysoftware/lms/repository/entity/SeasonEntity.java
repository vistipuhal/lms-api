package com.fairwaysoftware.lms.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "Season")
@Table(name = "season")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeasonEntity {

    private static final String SEQ = "season_id_seq";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "season_id", updatable = false)
    private Integer seasonId;

    @ManyToOne(optional = false)
    @MapsId("league_id")
    @JoinColumn(name = "league_id", nullable = false)
    @NotNull
    private LeagueEntity league;

    @Column(name = "start_date", nullable = false)
    @NotNull
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NotNull
    private LocalDate endDate;

}
