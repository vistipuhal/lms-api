package com.fairwaysoftware.lms.security;

import com.fairwaysoftware.lms.service.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityFacade {

    public static Integer getCurrentUserId() {
        return getCurrentUser().map(User::getUserId).orElse(null);
    }

    public static Optional<User> getCurrentUser() {
        return Optional.of((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public static void isCurrentUser(Integer id) {
        if (id == null || getCurrentUserId() == null || !getCurrentUserId().equals(id)) {
            throw new SecurityException();
        }
    }

}
