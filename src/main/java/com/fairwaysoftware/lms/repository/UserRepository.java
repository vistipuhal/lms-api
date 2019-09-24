package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
