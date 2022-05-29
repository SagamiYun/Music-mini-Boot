package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.ArtistCreateRequest;
import com.sagamiyun.musicapi.dto.ArtistDto;
import com.sagamiyun.musicapi.dto.ArtistUpdateRequest;
import com.sagamiyun.musicapi.entity.Artist;
import com.sagamiyun.musicapi.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper {

    Artist createEntity(ArtistCreateRequest artistCreateRequest);

    Artist updateEntity(@MappingTarget Artist artist, ArtistUpdateRequest artistUpdateRequest);

    ArtistDto toDto(Artist artist);

    ArtistVo toVo(ArtistDto artistDto);
}