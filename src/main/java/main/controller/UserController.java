package main.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import main.models.UserPostDto;
import main.models.UserResponseDto;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/user-api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation("Получение всех пользователей")
    @GetMapping()
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation("Добавление пользователя")
    @PostMapping()
    public UserResponseDto addUser(@RequestBody UserPostDto dto) {
        return userService.addUser(dto);
    }

    @ApiOperation("Удаление всех пользователей")
    @DeleteMapping()
    public String deleteUsers() {
        return userService.deleteAll();
    }

    @ApiOperation("Удаление пользователя по его ID")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteById(id);
    }

    @ApiOperation("Обновление информации пользователя по его ID")
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Integer id, @RequestBody UserPostDto dto) {
        return userService.updateUserById(id, dto);
    }
}
