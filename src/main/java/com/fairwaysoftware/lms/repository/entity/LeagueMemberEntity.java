package com.fairwaysoftware.lms.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "LeagueMember")
@Table(name = "league_member")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeagueMemberEntity {

    private static final String SEQ = "league_member_id_seq";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, initialValue = 1000, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "league_member_id", updatable = false)
    private Integer leagueMemberId;

    @ManyToOne
    @MapsId("league_id")
    @JoinColumn(name = "league_id", nullable = false)
    private LeagueEntity league;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfileEntity userProfile;

}
