package com.example.demo.global.util.range;

import org.springframework.data.domain.Sort;

public record Rangeable(
        Sort sort,
        Integer first,
        Integer limit
) {
}
