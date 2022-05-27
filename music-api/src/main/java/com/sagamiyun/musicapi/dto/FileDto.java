package com.sagamiyun.musicapi.dto;

import com.sagamiyun.musicapi.enums.FileStatus;
import com.sagamiyun.musicapi.enums.FileType;
import com.sagamiyun.musicapi.enums.Storage;
import lombok.Data;

import java.util.Date;

@Data
public class FileDto {
    private String id;

    private String name;

    private String key;

    private String ext;

    private Long size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}