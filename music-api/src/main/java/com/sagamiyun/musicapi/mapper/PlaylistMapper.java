package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.PlaylistDto;
import com.sagamiyun.musicapi.entity.Playlist;
import com.sagamiyun.musicapi.vo.PlaylistVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
