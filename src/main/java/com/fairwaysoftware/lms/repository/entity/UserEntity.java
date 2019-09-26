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
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @Column(name = "user_id", updatable = false)
    private Integer userId;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "first_name", length = 100, nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    @NotEmpty
    private String lastName;

}
