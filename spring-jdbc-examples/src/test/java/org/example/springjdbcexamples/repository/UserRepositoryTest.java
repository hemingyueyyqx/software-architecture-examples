package org.example.springjdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.springjdbcexamples.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j

class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        User user = User.builder()
                .name("Liu")
                .account("admin")
                .password("admin")
                .role(User.ADMIN)
                .build();
        userRepository.save(user);
    }
    @Test
    void findById() {
        userRepository.findById("1315915041734668288")
                .ifPresent(user -> log.debug("{}", user));
    }


}