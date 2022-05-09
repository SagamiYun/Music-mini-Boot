package com.sagamiyun.musicapi.service;

import com.sagamiyun.musicapi.dto.UserCreateRequest;
import com.sagamiyun.musicapi.dto.UserDto;
import com.sagamiyun.musicapi.dto.UserUpdateRequest;
import com.sagamiyun.musicapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    @Override
    User loadUserByUsername(String username);

    UserDto create(UserCreateRequest userCreateRequest);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);
}
