package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.LeagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<LeagueEntity, Integer> {
}
