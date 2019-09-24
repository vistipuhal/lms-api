package com.fairwaysoftware.lms.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer userId;

    @NotEmpty
    private String email;

    @NotEmpty
    private String passwordHash;

}
