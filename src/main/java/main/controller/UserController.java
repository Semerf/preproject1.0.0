package main.controller;

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

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("add")
    public User addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userName) {
        UserPostDto dto = new UserPostDto(firstName, lastName, email, userName);
        return userService.addUser(dto);
    }

    @DeleteMapping("deleteAll")
    public void deleteUsers() {
        userService.deleteAll();
    }

    @DeleteMapping("delete")
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteById(id);
    }

    @PostMapping("update")
    public void updateUser(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userName) {
        UserPostDto dto = new UserPostDto(firstName, lastName, email, userName);
        userService.updateUserById(id, dto);
    }
}
