package com.example.graph.repository;

import com.example.graph.dto.AnalyticResDto;
import com.example.graph.dto.QAnalyticDto;
import com.example.graph.dto.QAnalyticResDto;
import com.example.graph.entity.QAnalytic;
import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class AnalyticCustomRepositoryImpl implements AnalyticCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<AnalyticResDto> findTotalsByChannelAndCollectedAt(String channelName, LocalDate collectedAt) {
        QAnalytic analytic = QAnalytic.analytic;

        return jpaQueryFactory
                .select(new QAnalyticResDto(
                        analytic.channelName,
                        analytic.collectedAt,
                        analytic.validViews.sum(),
                        analytic.views.sum(),
                        analytic.subscribers.sum(),
                        analytic.watchTimeHours.sum(),
                        GroupBy.list(new QAnalyticDto(
                                analytic.id,
                                analytic.contentId,
                                analytic.videoTitle,
                                analytic.publishTime,
                                analytic.videoLength,
                                analytic.validViews,
                                analytic.views,
                                analytic.watchTimeHours,
                                analytic.subscribers,
                                analytic.impressions,
                                analytic.impressionClickRate
                        ))
                ))
                .from(analytic)
                .groupBy(analytic.channelName, analytic.collectedAt)
                .orderBy(analytic.collectedAt.asc(), analytic.channelName.asc())
                .fetch();
    }
}
