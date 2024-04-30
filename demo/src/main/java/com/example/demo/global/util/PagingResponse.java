package com.example.demo.global.util;

import java.util.List;

public record PagingResponse<T>(
        List<T> data,
        Integer totalPages,
        Long totalElements
) {
    public static <T> PagingResponse<T> of(List<T> data, Integer totalPages, Long totalElements) {
        return new PagingResponse<>(data, totalPages, totalElements);
    }
}
