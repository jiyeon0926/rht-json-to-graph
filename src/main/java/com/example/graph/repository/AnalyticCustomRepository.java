package com.example.graph.repository;

import com.example.graph.dto.AnalyticDto;
import com.example.graph.dto.AnalyticTotalsResDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AnalyticCustomRepository {

    List<AnalyticTotalsResDto> findTotalsByCollectedAtAndChannel();

    List<AnalyticDto> findDetailsByCollectedAtAndChannel(Set<LocalDate> collectedAtSet, Set<String> channelNameSet);

    List<AnalyticTotalsResDto> findTotalsWithVideos();
}
