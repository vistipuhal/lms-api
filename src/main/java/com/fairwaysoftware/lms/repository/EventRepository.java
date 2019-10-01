package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {

    @Query("select e from Event e where e.league.leagueId = :leagueId and e.season.seasonId = :seasonId")
    List<EventEntity> findByLeagueIdAndSeasonId(@Param("leagueId") Integer leagueId, @Param("seasonId") Integer seasonId);

}
