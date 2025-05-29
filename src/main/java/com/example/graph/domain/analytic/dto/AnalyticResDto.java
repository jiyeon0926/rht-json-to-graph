package com.example.graph.domain.analytic.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AnalyticResDto {

    private final String channelName;
    private final LocalDate collectedAt;
    private final List<AnalyticVideoDto> videos;
}
