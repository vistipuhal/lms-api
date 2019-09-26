package com.fairwaysoftware.lms.repository;

import com.fairwaysoftware.lms.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select e from User e where e.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);

}
