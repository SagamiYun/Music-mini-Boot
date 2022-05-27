package com.sagamiyun.musicapi.vo;

import com.sagamiyun.musicapi.enums.MusicStatus;
import lombok.Data;

@Data
public class MusicVo extends BaseVo {
    private String id;

    private String name;

    private MusicStatus status;

    private String description;

    private FileVo file;
}