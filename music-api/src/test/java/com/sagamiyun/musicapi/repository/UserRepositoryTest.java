package com.sagamiyun.musicapi.repository;

import com.sagamiyun.musicapi.entity.User;
import com.sagamiyun.musicapi.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void getByUsername() {
        User user = new User();
        user.setUsername("sagamiyun");
        user.setNickname("砂岩弥云");
        user.setLocked(false);
        user.setEnabled(true);
        user.setPassword("123456");
        user.setGender(Gender.MALE);
        user.setLastLoginIp("localhost");
        user.setLastLoginTime(new Date());

        User saveUser = repository.save(user);
        User result = repository.getByUsername("sagamiyun");
        System.out.println(result.toString());
    }
}