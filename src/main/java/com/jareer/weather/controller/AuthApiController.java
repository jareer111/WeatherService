package com.jareer.weather.controller;

import com.jareer.weather.authentication.jwt.JwtTokenUtil;
import com.jareer.weather.entity.User;
import com.jareer.weather.models.AuthRequest;
import com.jareer.weather.models.AuthResponse;
import com.jareer.weather.service.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthApiController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthRequest request) {
        authenticate(request.getEmail(), request.getPassword());
        User user = jwtUserDetailsService.loadUserByUsername(request.getEmail());
        String accessToken = jwtTokenUtil.generateAccessToken(user);
        AuthResponse response = new AuthResponse(request.getEmail(), accessToken);
        return ResponseEntity.ok(response);

    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
