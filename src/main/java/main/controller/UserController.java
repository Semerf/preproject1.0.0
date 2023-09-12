package main.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import main.models.User;
import main.models.UserPostDto;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/user-api/")
@RequiredArgsConstructor

public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Получение всех пользователей")
    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation("Добавление пользователя")
    @PostMapping("add")
    public User addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userName) {
        UserPostDto dto = new UserPostDto(firstName, lastName, email, userName);
        return userService.addUser(dto);
    }

    @ApiOperation("Удаление всех пользователей")
    @DeleteMapping("deleteAll")
    public void deleteUsers() {
        userService.deleteAll();
    }
    @ApiOperation("Удаление пользователя по его ID")
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @ApiOperation("Обновление информации пользователя по его ID")
    @PostMapping("update/{id}")
    public void updateUser(@PathVariable Integer id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userName) {
        UserPostDto dto = new UserPostDto(firstName, lastName, email, userName);
        userService.updateUserById(id, dto);
    }
}
