package com.example.graph.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AnalyticSimpleResDto {

    private final String channelName;
    private final LocalDate collectedAt;
    private final List<AnalyticDto> videos;
}
