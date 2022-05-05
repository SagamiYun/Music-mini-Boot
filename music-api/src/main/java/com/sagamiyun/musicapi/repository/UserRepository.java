package com.sagamiyun.musicapi.repository;

import com.sagamiyun.musicapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
    User getByUsernameAndNickname(String username, String nickname);

    Optional<User> findByUsername(String username);
}
