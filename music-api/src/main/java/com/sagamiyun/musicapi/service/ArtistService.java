package com.sagamiyun.musicapi.service;

import com.sagamiyun.musicapi.dto.ArtistCreateRequest;
import com.sagamiyun.musicapi.dto.ArtistDto;
import com.sagamiyun.musicapi.dto.ArtistUpdateRequest;

import java.util.List;

public interface ArtistService {
    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest);

    List<ArtistDto> list();
}