package com.sagamiyun.musicapi.controller;

import com.sagamiyun.musicapi.mapper.PlaylistMapper;
import com.sagamiyun.musicapi.service.PlaylistService;
import com.sagamiyun.musicapi.vo.PlaylistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistMapper playlistMapper;


    @GetMapping("/{id}")
    public PlaylistVo get(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.get(id));
    }

    @Autowired
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }

    @Autowired
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
}