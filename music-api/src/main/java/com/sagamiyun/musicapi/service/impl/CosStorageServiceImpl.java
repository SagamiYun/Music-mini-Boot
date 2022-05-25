package com.sagamiyun.musicapi.service.impl;

import com.sagamiyun.musicapi.dto.FileUploadDto;
import com.sagamiyun.musicapi.service.StorageService;
import org.springframework.stereotype.Service;

@Service("COS")
public class CosStorageServiceImpl implements StorageService {
    @Override
    public FileUploadDto initFileUpload() {
        return null;
    }
}
