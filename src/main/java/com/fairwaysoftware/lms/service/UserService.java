package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.repository.UserProfileRepository;
import com.fairwaysoftware.lms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@AllArgsConstructor
@Validated
public class UserService {

    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;


}
