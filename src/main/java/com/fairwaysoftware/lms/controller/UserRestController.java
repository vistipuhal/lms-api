package com.fairwaysoftware.lms.controller;

import com.fairwaysoftware.lms.Application;
import com.fairwaysoftware.lms.security.SecurityFacade;
import com.fairwaysoftware.lms.service.UserService;
import com.fairwaysoftware.lms.service.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Application.BASE_PATH + "/users")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @PostMapping("/currentUser")
    public User saveCurrentUser(@RequestBody User user) {
        if (user.getUserId() == null || !SecurityFacade.getCurrentUserId().equals(user.getUserId())) {
            //TODO What to throw here
            throw new RuntimeException();
        }
        user = userService.update(user);
        user.setPasswordHash(null);
        return user;
    }

}
