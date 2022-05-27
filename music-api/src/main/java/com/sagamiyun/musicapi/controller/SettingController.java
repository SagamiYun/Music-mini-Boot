package com.sagamiyun.musicapi.controller;

import com.sagamiyun.musicapi.mapper.SiteSettingMapper;
import com.sagamiyun.musicapi.service.SettingService;
import com.sagamiyun.musicapi.vo.SiteSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
public class SettingController {

    private SettingService settingService;

    private SiteSettingMapper siteSettingMapper;

    @GetMapping("/site")
    public SiteSettingVo getSiteSetting() {
        return siteSettingMapper.toVo(settingService.getSiteSetting());
    }

    @Autowired
    public void setSettingService(SettingService settingService) {
        this.settingService = settingService;
    }

    @Autowired
    public void setSiteSettingMapper(SiteSettingMapper siteSettingMapper) {
        this.siteSettingMapper = siteSettingMapper;
    }
}