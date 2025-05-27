package com.example.graph.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class AnalyticDto {

    private final Long id; // 고유 식별자
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

    @QueryProjection
    public AnalyticDto(Long id, String contentId, String videoTitle,
                       LocalDateTime publishTime, String videoLength, int validViews,
                       int views, BigDecimal watchTimeHours, int subscribers,
                       int impressions, BigDecimal impressionsClickRate) {
        this.id = id;
        this.contentId = contentId;
        this.videoTitle = videoTitle;
        this.publishTime = publishTime;
        this.videoLength = videoLength;
        this.validViews = validViews;
        this.views = views;
        this.watchTimeHours = watchTimeHours;
        this.subscribers = subscribers;
        this.impressions = impressions;
        this.impressionsClickRate = impressionsClickRate;
    }
}
