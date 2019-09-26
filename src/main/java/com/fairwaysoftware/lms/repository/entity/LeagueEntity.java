package com.fairwaysoftware.lms.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "League")
@Table(name = "league")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeagueEntity {

    private static final String SEQ = "league_id_seq";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "league_id", updatable = false)
    private Integer leagueId;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    @NotEmpty
    private String name;

}
