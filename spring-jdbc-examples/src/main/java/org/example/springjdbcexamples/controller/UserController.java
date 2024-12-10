package org.example.springjdbcexamples.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springjdbcexamples.dox.Address;
import org.example.springjdbcexamples.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;
    @GetMapping("addresses")
    public Map<String,Object> getAddresses(@RequestAttribute String uid) {
        List<Address> addresses = userService.listAddresses(uid);
        return Map.of("addresses", addresses);
    }
}
