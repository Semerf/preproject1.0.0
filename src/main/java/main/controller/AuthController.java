package main.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import main.model.JwtRequest;
import main.model.UserPostDto;
import main.service.RegisterService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final RegisterService registerService;

    @ApiOperation("Аутентификация")
    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return registerService.createAuthToken(authRequest);
    }

    @ApiOperation("Регистрация")
    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody UserPostDto userPostDto) {
        return registerService.createNewUser(userPostDto);
    }
}