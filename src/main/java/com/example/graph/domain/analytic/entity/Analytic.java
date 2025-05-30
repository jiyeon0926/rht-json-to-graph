package com.example.graph.domain.analytic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name="youtube_analytics")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Analytic {

    @Id
    private Long id;

    private String channelName;
    private String contentId;
    private String videoTitle;
    private LocalDate publishAt;
    private String videoLength;
    private int validViews;
    private int views;
    private float watchTimeHours;
    private int subscribers;
    private int impressions;
    private float impressionClickRate;
    private LocalDate collectedAt;
}