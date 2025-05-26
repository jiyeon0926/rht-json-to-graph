package com.example.graph.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class AnalyticResDto {

    private final Long id;
    private final int subscribers;
    private final BigDecimal impressionClickRate;
}
