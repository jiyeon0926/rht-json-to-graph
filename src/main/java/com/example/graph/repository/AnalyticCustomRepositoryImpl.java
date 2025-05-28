package com.example.graph.repository;

import com.example.graph.dto.AnalyticDto;
import com.example.graph.dto.AnalyticTotalsResDto;
import com.example.graph.entity.QAnalytic;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AnalyticCustomRepositoryImpl implements AnalyticCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    // 수집일과 채널명에 따른 집계 데이터 조회
    @Override
    public List<AnalyticTotalsResDto> findTotalsByCollectedAtAndChannel() {
        QAnalytic analytic = QAnalytic.analytic;

        return jpaQueryFactory
                .select(Projections.constructor(
                        AnalyticTotalsResDto.class,
                        analytic.channelName,
                        analytic.collectedAt,
                        analytic.validViews.sum().intValue(),
                        analytic.views.sum().intValue(),
                        analytic.subscribers.sum().intValue(),
                        analytic.watchTimeHours.sum().coalesce(BigDecimal.ZERO)
                ))
                .from(analytic)
                .groupBy(analytic.collectedAt, analytic.channelName) // 수집일과 채널명으로 group by
                .orderBy(analytic.collectedAt.asc(), analytic.channelName.asc())
                .fetch();
    }

    // 수집일과 채널명에 따른 영상 상세 데이터를 조회
    @Override
    public List<AnalyticDto> findDetailsByCollectedAtAndChannel(Set<LocalDate> colelctedAtSet, Set<String> channelNameSet) {
        QAnalytic analytic = QAnalytic.analytic;

        return jpaQueryFactory
                .select(Projections.constructor(
                        AnalyticDto.class,
                        analytic.id,
                        analytic.channelName,
                        analytic.collectedAt,
                        analytic.contentId,
                        analytic.videoTitle,
                        analytic.publishTime,
                        analytic.videoLength,
                        analytic.validViews.intValue(),
                        analytic.views.intValue(),
                        analytic.watchTimeHours.coalesce(BigDecimal.ZERO),
                        analytic.subscribers.intValue(),
                        analytic.impressions.intValue(),
                        analytic.impressionClickRate.coalesce(BigDecimal.ZERO)
                ))
                .from(analytic)
                .where(
                        analytic.collectedAt.in(colelctedAtSet),
                        analytic.channelName.in(channelNameSet)
                )
                .orderBy(analytic.id.asc())
                .fetch();
    }

    @Override
    public List<AnalyticTotalsResDto> findTotalsWithVideos() {
        List<AnalyticTotalsResDto> totals = findTotalsByCollectedAtAndChannel();

        // 여러 수집일이 아닌 특정 수집일 하나만 필요하기 때문에 List가 아닌 Set 사용
        Set<LocalDate> colelctedAtSet = totals.stream()
                .map(AnalyticTotalsResDto::getCollectedAt)
                .collect(Collectors.toSet());

        Set<String> channelNameSet = totals.stream()
                .map(AnalyticTotalsResDto::getChannelName)
                .collect(Collectors.toSet());

        List<AnalyticDto> details = findDetailsByCollectedAtAndChannel(colelctedAtSet, channelNameSet);

        // 수집일과 채널명으로 묶기 위함용
        Map<String, List<AnalyticDto>> groupedDetails = details.stream()
                .collect(Collectors.groupingBy(detail -> detail.getCollectedAt().toString() + "|" + detail.getChannelName()));

        // groupedDetails 맵에서 수집일 및 채널명을 키로 사용하여, 해당 상세 데이터를 AnalyticResDto의 videos 필드에 설정
        totals.forEach(total -> {
            String key = total.getCollectedAt().toString() + "|" + total.getChannelName();
            total.setVideos(groupedDetails.getOrDefault(key, Collections.emptyList()));
        });

        return totals;
    }
}
