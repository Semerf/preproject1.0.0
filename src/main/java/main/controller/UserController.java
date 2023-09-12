package main.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import main.models.User;
import main.models.UserPostDto;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/user-api/")
@RequiredArgsConstructor

public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Получение всех пользователей")
    @GetMapping()
    public List<UserPostDto> getAllUsers() {
        List<UserPostDto> userPostDtos = new ArrayList<>();
        for (User user : userService.getAllUsers()) {
            userPostDtos.add(new UserPostDto(user));
        }
        return userPostDtos;
    }

    @ApiOperation("Добавление пользователя")
    @PostMapping()
    public UserPostDto addUser(@RequestBody UserPostDto dto) {
        return userService.addUser(dto);
    }

    @ApiOperation("Удаление всех пользователей")
    @DeleteMapping()
    public String deleteUsers() {
        userService.deleteAll();
        return "Пользователи удалены";
    }

    @ApiOperation("Удаление пользователя по его ID")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return "Пользователь " + userService.deleteById(id) + " удален";
    }

    @ApiOperation("Обновление информации пользователя по его ID")
    @PostMapping("/{id}")
    public UserPostDto updateUser(@PathVariable Integer id, @RequestBody UserPostDto dto) {
        return userService.updateUserById(id, dto);
    }
}
