package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.AuthenticationRequest;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.AuthenticationResponse;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.security.CustomUserDetailsService;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.security.JwtUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    CustomUserDetailsService customUserDetailsService,
                                    JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        if (authenticationRequest.getUsername() == null || authenticationRequest.getPassword() == null) {
            throw new BadCredentialsException("Username or password invalid.");
        }

        final UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        SecurityContextHolder.getContext().getAuthentication().getCredentials();

        return ResponseEntity.ok(
                new AuthenticationResponse(
                    jwt,
                    SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next().getAuthority()
                    )
        );
    }
}
