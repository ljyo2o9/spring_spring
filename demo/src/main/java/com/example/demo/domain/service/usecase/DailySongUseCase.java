package com.example.demo.domain.service.usecase;

import com.example.demo.domain.entity.DailySongEntity;
import com.example.demo.global.util.PagingResponse;
import com.example.demo.global.util.range.Rangeable;


import java.util.List;

public interface DailySongUseCase {
    void apply(String url);

    void del(Long id);

    void edit(Long id, String url);

    List<DailySongEntity> getAll();

    PagingResponse<DailySongEntity> getPageAll(Integer page, Integer size);

    DailySongEntity findById(Long id);

    List<DailySongEntity> findInRange(Rangeable rangeable);
}
