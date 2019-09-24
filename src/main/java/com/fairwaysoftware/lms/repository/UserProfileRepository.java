package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Integer> {
}
