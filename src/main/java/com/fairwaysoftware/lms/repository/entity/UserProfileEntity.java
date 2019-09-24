package com.fairwaysoftware.lms.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity(name = "UserProfile")
@Table(name = "app_user_profile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileEntity {

    @Id
    @Column(name = "user_id", updatable = false)
    private Integer userId;

    @Column(name = "first_name", nullable = false, length = 100)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    @NotEmpty
    private String lastName;

}
