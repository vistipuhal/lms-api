package com.fairwaysoftware.lms.security;

import com.fairwaysoftware.lms.Application;
import com.fairwaysoftware.lms.service.UserService;
import com.fairwaysoftware.lms.service.domain.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Application.BASE_PATH + "/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private TokenHelper tokenHelper;
    private ModelMapper modelMapper;

    @PostMapping
    public AuthResponse post(@RequestBody @Valid AuthRequest authRequest) {
        User user = userService.findByEmail(authRequest.getEmail()).orElseThrow(() -> new UnauthorizedException());
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPasswordHash())) {
            throw new UnauthorizedException();
        }
        return new AuthResponse(tokenHelper.generateToken(user));
    }

    @GetMapping("/currentUser")
    public User getCurrentUser() {
        return SecurityFacade.getCurrentUser().map(user -> {
            user.setPasswordHash(null);
            return user;
        }).get();
    }

}
