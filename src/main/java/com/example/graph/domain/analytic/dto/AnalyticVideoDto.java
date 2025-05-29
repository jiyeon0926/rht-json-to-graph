package com.example.graph.domain.analytic.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class AnalyticVideoDto {

    private final Long id;
    private final String contentId;
    private final String videoTitle;
    private final LocalDate publishAt;
    private final String videoLength;
    private final int validViews;
    private final int views;
    private final float watchTimeHours;
    private final int subscribers;
    private final int impressions;
    private final float impressionsClickRate;
}
