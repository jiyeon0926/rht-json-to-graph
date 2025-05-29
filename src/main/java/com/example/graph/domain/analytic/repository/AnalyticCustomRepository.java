package com.example.graph.domain.analytic.repository;

import com.example.graph.domain.analytic.dto.AnalyticResDto;
import com.example.graph.domain.analytic.dto.AnalyticTotalsResDto;
import com.example.graph.domain.analytic.dto.AnalyticVideoDetailDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AnalyticCustomRepository {

    List<AnalyticResDto> findByCollectedAtAndChannel();

    List<AnalyticTotalsResDto> findTotalsByCollectedAtAndChannel();

    List<AnalyticVideoDetailDto> findDetailsByCollectedAtAndChannel(Set<LocalDate> collectedAtSet, Set<String> channelNameSet);

    List<AnalyticTotalsResDto> findTotalsWithVideos();
}
