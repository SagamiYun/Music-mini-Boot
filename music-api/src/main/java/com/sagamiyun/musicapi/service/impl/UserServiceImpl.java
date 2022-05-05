package com.sagamiyun.musicapi.service.impl;

import com.sagamiyun.musicapi.dto.UserCreateDto;
import com.sagamiyun.musicapi.dto.UserDto;
import com.sagamiyun.musicapi.entity.User;
import com.sagamiyun.musicapi.exception.BizException;
import com.sagamiyun.musicapi.exception.ExceptionType;
import com.sagamiyun.musicapi.mapper.UserMapper;
import com.sagamiyun.musicapi.repository.UserRepository;
import com.sagamiyun.musicapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;


    @Override
    public List<UserDto> list() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user = mapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}