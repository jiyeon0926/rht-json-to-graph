package com.example.graph.domain.analytic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime publishTime;
    private String videoLength;
    private int validViews;
    private int views;

    @Column(precision = 10, scale = 2)
    private BigDecimal watchTimeHours;

    private int subscribers;
    private int impressions;

    @Column(precision = 5, scale = 2)
    private BigDecimal impressionClickRate;

    private LocalDate collectedAt;
}