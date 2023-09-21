package main.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import main.mapper.UserMapper;
import main.model.UserResponseDto;
import main.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @ApiOperation("Получение информации о пользователя")
    @GetMapping()
    public UserResponseDto getUserInfo() {
        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.toUserResponseDto(userService.findByUsername(name));
    }
}
