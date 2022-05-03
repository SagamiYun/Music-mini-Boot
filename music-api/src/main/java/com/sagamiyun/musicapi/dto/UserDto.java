package com.sagamiyun.musicapi.dto;


import com.sagamiyun.musicapi.vo.RoleVo;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roles;
}
