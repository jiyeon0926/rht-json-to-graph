package com.example.graph.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
public class AnalyticResDto {

    private final String channelName; // 채널명
    private final LocalDate collectedAt; // 수집일
    private final int totalValidViews; // 총 유효 조회수
    private final int totalViews; // 총 조회수
    private final int totalSubscribers; // 신규 구독자 수의 누적 합계 (!= 채널 구독자 수)
    private final BigDecimal totalWatchTimeHours; // 총 시청 시간
    private final List<AnalyticDto> videos;

    @QueryProjection
    public AnalyticResDto(String channelName, LocalDate collectedAt, int totalValidViews,
                          int totalViews, int totalSubscribers, BigDecimal totalWatchTimeHours,
                          List<AnalyticDto> videos) {
        this.channelName = channelName;
        this.collectedAt = collectedAt;
        this.totalValidViews = totalValidViews;
        this.totalViews = totalViews;
        this.totalSubscribers = totalSubscribers;
        this.totalWatchTimeHours = totalWatchTimeHours;
        this.videos = videos;
    }
}