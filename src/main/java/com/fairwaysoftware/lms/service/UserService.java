package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.repository.UserRepository;
import com.fairwaysoftware.lms.repository.entity.UserEntity;
import com.fairwaysoftware.lms.service.domain.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public Optional<User> findById(@NotNull Integer userId) {
        return userRepository.findById(userId).map(e -> modelMapper.map(e, User.class));
    }

    public Optional<User> findByEmail(@NotEmpty String email) {
        return userRepository.findByEmail(email).map(e -> modelMapper.map(e, User.class));
    }

    @Transactional
    public User create(@Valid User user) {
        if (user.getUserId() != null) {
            throw new ServiceException("CreateError: UserId must be null");
        }
        if (!StringUtils.isEmpty(user.getPasswordHash())) {
            user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        }
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, User.class);
    }

    @Transactional
    public User update(@Valid User user) {
        UserEntity userEntity = userRepository.findById(user.getUserId()).orElseThrow(() -> new ServiceException("Unknown UserId: " + user.getUserId()));
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, User.class);
    }


}
