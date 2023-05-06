package dev.iuhoay.java.controller;

import dev.iuhoay.java.dto.UserDTO;
import dev.iuhoay.java.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }
}
