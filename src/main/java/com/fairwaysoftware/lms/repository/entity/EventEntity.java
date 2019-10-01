package com.fairwaysoftware.lms.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "Event")
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventEntity {

    private static final String SEQ = "event_id_seq";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "event_id", updatable = false)
    private Integer eventId;

    @ManyToOne(optional = false)
    @MapsId("league_id")
    @JoinColumn(name = "league_id", nullable = false)
    @NotNull
    private LeagueEntity league;

    @ManyToOne()
    @MapsId("season_id")
    @JoinColumn(name = "season_id", nullable = false)
    @NotNull
    private SeasonEntity season;

    @Column(name = "name", length = 255, nullable = false, unique = true)
    @NotEmpty
    private String name;

    @Column(name = "description", length = 1000, nullable = false, unique = true)
    @NotEmpty
    private String description;

    @Column(name = "event_date", nullable = false)
    @NotNull
    private LocalDate eventDate;

    @Column(name = "event_time", nullable = false)
    @NotNull
    private LocalTime eventTime;

}
