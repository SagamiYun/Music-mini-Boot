package com.sagamiyun.musicapi.service;

import com.sagamiyun.musicapi.dto.FileUploadDto;
import com.sagamiyun.musicapi.dto.FileUploadRequest;

public interface FileService {

    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);
}