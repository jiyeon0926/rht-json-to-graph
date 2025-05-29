package com.example.graph.domain.analytic.repository;

import com.example.graph.domain.analytic.dto.AnalyticDetailDto;
import com.example.graph.domain.analytic.dto.AnalyticSimpleResDto;
import com.example.graph.domain.analytic.dto.AnalyticTotalsResDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AnalyticCustomRepository {

    List<AnalyticTotalsResDto> findTotalsByCollectedAtAndChannel();

    List<AnalyticDetailDto> findDetailsByCollectedAtAndChannel(Set<LocalDate> collectedAtSet, Set<String> channelNameSet);

    List<AnalyticTotalsResDto> findTotalsWithVideos();

    List<AnalyticSimpleResDto> findByCollectedAtAndChannel();
}
