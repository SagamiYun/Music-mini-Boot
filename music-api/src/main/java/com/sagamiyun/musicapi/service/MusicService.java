package com.sagamiyun.musicapi.service;

import com.sagamiyun.musicapi.dto.MusicCreateRequest;
import com.sagamiyun.musicapi.dto.MusicDto;
import com.sagamiyun.musicapi.dto.MusicUpdateRequest;

import java.util.List;

public interface MusicService {
    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);

    void close(String id);
}
