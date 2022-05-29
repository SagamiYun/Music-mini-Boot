package com.sagamiyun.musicapi.service.impl;

import com.sagamiyun.musicapi.dto.ArtistCreateRequest;
import com.sagamiyun.musicapi.dto.ArtistDto;
import com.sagamiyun.musicapi.dto.ArtistUpdateRequest;
import com.sagamiyun.musicapi.entity.Artist;
import com.sagamiyun.musicapi.enums.ArtistStatus;
import com.sagamiyun.musicapi.exception.BizException;
import com.sagamiyun.musicapi.exception.ExceptionType;
import com.sagamiyun.musicapi.mapper.ArtistMapper;
import com.sagamiyun.musicapi.repository.ArtistRepository;
import com.sagamiyun.musicapi.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArtistServiceImpl extends BaseService implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public ArtistDto create(ArtistCreateRequest artistCreateRequest) {
        Artist artist = mapper.createEntity(artistCreateRequest);
        artist.setStatus(ArtistStatus.DRAFT);
        artist.setCreatedBy(getCurrentUserEntity());
        artist.setUpdatedBy(getCurrentUserEntity());
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest) {
        Optional<Artist> artistOptional = repository.findById(id);
        if (!artistOptional.isPresent()) {
            throw new BizException(ExceptionType.ARTIST_NOT_FOUND);
        }
        Artist artist = mapper.updateEntity(artistOptional.get(), artistUpdateRequest);

        return mapper.toDto(repository.save(artist));
    }

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }
}
