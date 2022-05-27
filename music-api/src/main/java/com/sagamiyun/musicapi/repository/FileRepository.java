package com.sagamiyun.musicapi.repository;

import com.sagamiyun.musicapi.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
