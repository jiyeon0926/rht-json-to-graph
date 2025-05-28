package com.example.graph.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AnalyticTotalsResDto {

    private final String channelName; // 채널명
    private final LocalDate collectedAt; // 수집일
    private final int totalValidViews; // 총 유효 조회수
    private final int totalViews; // 총 조회수
    private final int totalSubscribers; // 신규 구독자 수의 누적 합계 (!= 채널 구독자 수)
    private final BigDecimal totalWatchTimeHours; // 총 시청 시간

    @Setter
    private List<AnalyticDto> videos;
}