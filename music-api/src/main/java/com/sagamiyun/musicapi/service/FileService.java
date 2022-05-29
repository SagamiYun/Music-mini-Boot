package com.sagamiyun.musicapi.service;

import com.sagamiyun.musicapi.dto.FileDto;
import com.sagamiyun.musicapi.dto.FileUploadDto;
import com.sagamiyun.musicapi.dto.FileUploadRequest;
import com.sagamiyun.musicapi.entity.File;
import com.sagamiyun.musicapi.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    File getFileEntity(String id);
}