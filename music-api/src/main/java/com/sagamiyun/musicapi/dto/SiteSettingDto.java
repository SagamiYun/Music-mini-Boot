package com.sagamiyun.musicapi.dto;

import com.sagamiyun.musicapi.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
