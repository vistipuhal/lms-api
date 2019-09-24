package com.fairwaysoftware.lms.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {

    private Integer userId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

}
