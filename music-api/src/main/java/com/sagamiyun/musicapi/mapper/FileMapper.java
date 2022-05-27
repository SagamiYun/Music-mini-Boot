package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.FileDto;
import com.sagamiyun.musicapi.dto.FileUploadRequest;
import com.sagamiyun.musicapi.entity.File;
import com.sagamiyun.musicapi.vo.FileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);
}
