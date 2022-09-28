package com.example.week8.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class CoordinateResponseDto {
    private final double x;
    private final double y;
}
