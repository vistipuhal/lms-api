package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.LeagueMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeagueMemberRepository extends JpaRepository<LeagueMemberEntity, Integer> {

    @Query("select e from LeagueMember e where e.league.leagueId = :leagueId order by e.user.lastName, e.user.firstName")
    List<LeagueMemberEntity> findByLeagueId(@Param("leagueId") Integer leagueId);

    @Query("select e from LeagueMember e where e.user.userId = :userId order by e.user.lastName, e.user.firstName")
    List<LeagueMemberEntity> findByUserId(@Param("userId") Integer userId);

}
