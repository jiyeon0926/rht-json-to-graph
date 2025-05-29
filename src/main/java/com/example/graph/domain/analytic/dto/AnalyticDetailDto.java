package com.example.graph.domain.analytic.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class AnalyticDetailDto {

    private final Long id; // 고유 식별자
    private final String channelName; // 채널명
    private final LocalDate collectedAt; // 수집일
    private final String contentId; // 영상 아이디
    private final String videoTitle; // 영상 제목
    private final LocalDateTime publishTime; // 영상 게시일
    private final String videoLength; // 영상 길이
    private final int validViews; // 유효 조회수
    private final int views; // 조회수
    private final BigDecimal watchTimeHours; // 시청 시간
    private final int subscribers; // 구독자 수
    private final int impressions; // 노출 수
    private final BigDecimal impressionsClickRate; // 노출 클릭률
}
