package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.FileDto;
import com.sagamiyun.musicapi.dto.FileUploadRequest;
import com.sagamiyun.musicapi.entity.File;
import com.sagamiyun.musicapi.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);

    File toEntity(FileDto fileDto);
}
