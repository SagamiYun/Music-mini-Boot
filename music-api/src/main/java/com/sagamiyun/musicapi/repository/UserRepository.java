package com.sagamiyun.musicapi.repository;

import com.sagamiyun.musicapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
    User getByUsernameAndNickname(String username, String nickname);
}
