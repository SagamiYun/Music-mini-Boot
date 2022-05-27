package com.sagamiyun.musicapi.repository;

import com.sagamiyun.musicapi.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}