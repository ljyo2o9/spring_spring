package com.example.demo.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record DailySongRequest(
        @NotBlank(message = "url입력하셈")
        String url
) {
}
