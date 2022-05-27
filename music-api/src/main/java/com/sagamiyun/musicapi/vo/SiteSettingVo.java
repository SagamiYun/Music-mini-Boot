package com.sagamiyun.musicapi.vo;

import com.sagamiyun.musicapi.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}