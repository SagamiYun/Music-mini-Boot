package com.sagamiyun.musicapi.service.impl;

import com.sagamiyun.musicapi.dto.MusicCreateRequest;
import com.sagamiyun.musicapi.dto.MusicDto;
import com.sagamiyun.musicapi.dto.MusicUpdateRequest;
import com.sagamiyun.musicapi.entity.Music;
import com.sagamiyun.musicapi.enums.MusicStatus;
import com.sagamiyun.musicapi.exception.BizException;
import com.sagamiyun.musicapi.exception.ExceptionType;
import com.sagamiyun.musicapi.mapper.MusicMapper;
import com.sagamiyun.musicapi.mapper.MusicRepository;
import com.sagamiyun.musicapi.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    private MusicRepository repository;

    private MusicMapper mapper;

    @Override
    public MusicDto create(MusicCreateRequest musicCreateRequest) {
        Music music = mapper.createEntity(musicCreateRequest);
        music.setStatus(MusicStatus.DRAFT);
        return mapper.toDto(repository.save(music));
    }

    @Override
    public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
        Music existMusic = getMusic(id);
        Music music = mapper.updateEntity(existMusic, musicUpdateRequest);
        return mapper.toDto(repository.save(music));
    }

    private Music getMusic(String id) {
        Optional<Music> musicOptional = repository.findById(id);
        if (!musicOptional.isPresent()) {
            throw new BizException(ExceptionType.MUSIC_NOT_FOUND);
        }
        return musicOptional.get();
    }

    @Override
    public List<MusicDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void publish(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.PUBLISHED);
        repository.save(music);
    }


    @Override
    public void close(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.CLOSED);
        repository.save(music);
    }


    @Autowired
    public void setRepository(MusicRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(MusicMapper mapper) {
        this.mapper = mapper;
    }
}
