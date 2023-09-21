package main.service;

import lombok.RequiredArgsConstructor;
import main.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import main.model.JwtRequest;
import main.model.JwtResponse;
import main.model.UserPostDto;
import main.model.UserResponseDto;
import main.entity.User;
import main.security.JwtTokenUtils;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserService userService;
    private final UserMapper mapper;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody UserPostDto userPostDto) {
        User user = mapper.toUser(userService.addUser(userPostDto));

        return ResponseEntity.ok(new UserResponseDto(user.getFirstName(), user.getLastName(), user.getUsername()));
    }
}