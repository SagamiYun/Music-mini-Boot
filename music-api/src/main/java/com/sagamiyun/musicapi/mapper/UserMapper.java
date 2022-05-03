package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.UserDto;
import com.sagamiyun.musicapi.entity.User;
import com.sagamiyun.musicapi.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}