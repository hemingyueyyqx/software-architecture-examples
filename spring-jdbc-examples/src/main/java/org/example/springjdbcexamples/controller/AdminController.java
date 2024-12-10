package org.example.springjdbcexamples.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjdbcexamples.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    private final UserService userService;
    @GetMapping("users/{uid}")
    public Map<String,Object> getUser(@PathVariable String uid) {
        return Map.of("user", userService.getUser(uid));
    }
}
