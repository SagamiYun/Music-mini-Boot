package com.sagamiyun.musicapi.service;

import com.sagamiyun.musicapi.dto.FileUploadDto;

import java.io.IOException;

public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}
