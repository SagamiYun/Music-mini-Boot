package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.UserCreateDto;
import com.sagamiyun.musicapi.dto.UserCreateRequest;
import com.sagamiyun.musicapi.dto.UserDto;
import com.sagamiyun.musicapi.dto.UserUpdateRequest;
import org.mapstruct.Mapper;
import com.sagamiyun.musicapi.entity.User;
import com.sagamiyun.musicapi.vo.UserVo;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

    User createEntity(UserCreateDto userCreateDto);
}
