package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.MusicCreateRequest;
import com.sagamiyun.musicapi.dto.MusicDto;
import com.sagamiyun.musicapi.dto.MusicUpdateRequest;
import com.sagamiyun.musicapi.entity.Music;
import com.sagamiyun.musicapi.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MusicMapper {
    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateRequest musicCreateRequest);

    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
