package com.example.demo.domain.service;

import com.example.demo.domain.entity.DailySongEntity;
import com.example.demo.domain.repository.DailySongRepository;
import com.example.demo.domain.service.usecase.DailySongUseCase;
import com.example.demo.global.error.custom.DailySongNotFound;
import com.example.demo.global.util.PagingResponse;
import com.example.demo.global.util.range.Rangeable;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DailySongService implements DailySongUseCase {
    private final DailySongRepository repository;

    @Override
    public void apply(String url) {
        DailySongEntity entity = DailySongEntity.builder().url(url).build();

        repository.save(entity);
    }

    @Override
    public void del(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Long id, String url) {
        DailySongEntity entity = findById(id);
        entity.updateUrl(url);
        repository.save(entity);
    }

    @Override
    public List<DailySongEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public PagingResponse<DailySongEntity> getPageAll(Integer page, Integer size) {
        Page<DailySongEntity> entityPage = repository.findAll(PageRequest.of(page, size));
        return PagingResponse.of(
                entityPage.getContent(),
                entityPage.getTotalPages(),
                entityPage.getTotalElements()
        );
    }

    @Override
    public DailySongEntity findById(Long id) {
        return repository.findById(id).orElseThrow(DailySongNotFound::new);
    }

    @Override
    public List<DailySongEntity> findInRange(Rangeable rangeable) {
        return repository.findInRange(rangeable);
    }
}
