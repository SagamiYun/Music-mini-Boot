package com.sagamiyun.musicapi.service;


import com.sagamiyun.musicapi.dto.UserCreateDto;
import com.sagamiyun.musicapi.dto.UserDto;
import com.sagamiyun.musicapi.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
