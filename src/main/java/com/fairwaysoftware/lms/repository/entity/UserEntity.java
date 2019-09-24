package com.fairwaysoftware.lms.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "User")
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    private static final String SEQ = "app_user_id_seq";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, initialValue = 1000, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "user_id", updatable = false)
    private Integer userId;

    @Column(name = "email", nullable = false, length = 100)
    @NotEmpty
    private String email;

    @Column(name = "password_hash", nullable = false)
    @NotEmpty
    private String passwordHash;

}
