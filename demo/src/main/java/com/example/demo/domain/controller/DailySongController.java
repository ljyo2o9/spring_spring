package com.example.demo.domain.controller;

import com.example.demo.domain.dto.DailySongRequest;
import com.example.demo.domain.entity.DailySongEntity;
import com.example.demo.domain.service.usecase.DailySongUseCase;
import com.example.demo.global.util.PagingResponse;
import com.example.demo.global.util.range.Rangeable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/songs")
public class DailySongController {
    private final DailySongUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void apply(@Valid @RequestBody DailySongRequest dailySongRequest) {
        useCase.apply(dailySongRequest.url());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DailySongEntity> getAll() {
        return useCase.getAll();
    }

    @GetMapping("/page")
    @ResponseStatus(HttpStatus.OK)
    public PagingResponse<DailySongEntity> getPageAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        return useCase.getPageAll(page, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DailySongEntity findById(@PathVariable Long id) {
        return useCase.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void del(@PathVariable(name = "id") Long id) {
        useCase.del(id);
    }

    @PatchMapping("/{id}")
    public void edit(@PathVariable(name = "id") Long id, @RequestBody DailySongRequest dailySongRequest) {
        useCase.edit(id, dailySongRequest.url());
    }

    @GetMapping("/range")
    public List<DailySongEntity> findInRange(@RequestParam(name = "first") Integer first, @RequestParam(name = "limit") Integer limit, @RequestParam(name = "sortBy") String sortBy) {
        Rangeable rangeable = new Rangeable(Sort.by(sortBy), first, limit);

        return useCase.findInRange(rangeable);
    }
}
