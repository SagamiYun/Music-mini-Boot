package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.SiteSettingDto;
import com.sagamiyun.musicapi.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
