package com.sagamiyun.musicapi.mapper;

import com.sagamiyun.musicapi.dto.FileUploadDto;
import com.sagamiyun.musicapi.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
