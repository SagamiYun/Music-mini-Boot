package com.sagamiyun.musicapi.service.impl;

import com.sagamiyun.musicapi.dto.FileDto;
import com.sagamiyun.musicapi.dto.FileUploadDto;
import com.sagamiyun.musicapi.dto.FileUploadRequest;
import com.sagamiyun.musicapi.entity.File;
import com.sagamiyun.musicapi.enums.FileStatus;
import com.sagamiyun.musicapi.enums.Storage;
import com.sagamiyun.musicapi.exception.BizException;
import com.sagamiyun.musicapi.exception.ExceptionType;
import com.sagamiyun.musicapi.mapper.FileMapper;
import com.sagamiyun.musicapi.repository.FileRepository;
import com.sagamiyun.musicapi.service.FileService;
import com.sagamiyun.musicapi.service.StorageService;
import com.sagamiyun.musicapi.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileServiceImpl extends BaseService implements FileService {

    private Map<String, StorageService> storageServices;

    private FileRepository repository;

    private FileMapper mapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException {
        // 创建File实体
        File file = mapper.createEntity(fileUploadRequest);
        file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
        file.setStorage(getDefaultStorage());
        file.setCreatedBy(getCurrentUserEntity());
        file.setUpdatedBy(getCurrentUserEntity());
        File savedFile = repository.save(file);

        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setKey(savedFile.getKey());
        fileUploadDto.setFileId(savedFile.getId());
        return fileUploadDto;
    }

    @Override
    public FileDto finishUpload(String id) {
        Optional<File> fileOptional = repository.findById(id);
        if (!fileOptional.isPresent()) {
            throw new BizException(ExceptionType.FILE_NOT_FOUND);
        }
        File file = fileOptional.get();
        // Todo: 是否是SUPER_ADMIN
        if (!Objects.equals(file.getCreatedBy().getId(), getCurrentUserEntity().getId())) {
            throw new BizException(ExceptionType.FILE_NOT_PERMISSION);
        }

        // Todo: 验证远程文件是否存在

        file.setStatus(FileStatus.UPLOADED);
        return mapper.toDto(repository.save(file));
    }


    // Todo: 后台设置当前Storage
    public Storage getDefaultStorage() {
        return Storage.COS;
    }


    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }

    @Autowired
    public void setRepository(FileRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(FileMapper mapper) {
        this.mapper = mapper;
    }
}
