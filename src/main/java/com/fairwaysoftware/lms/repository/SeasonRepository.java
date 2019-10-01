package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.SeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeasonRepository extends JpaRepository<SeasonEntity, Integer> {

    @Query("select s from Season s where s.league.leagueId = :leagueId order by s.startDate")
    List<SeasonEntity> findByLeagueId(@Param("leagueId") Integer leagueId);

}
