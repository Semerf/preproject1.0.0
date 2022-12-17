package main.controller;

import lombok.RequiredArgsConstructor;
import main.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("all")
    public List<User> getAllUsers() {
        return null;
    }


    @PostMapping("add")
    public User addUser() {
       return null;
    }

    @DeleteMapping("delete")
    public void deleteUsers() {

    }

    //TODO
}
