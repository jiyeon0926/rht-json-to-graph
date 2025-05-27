package com.example.graph.repository;

import com.example.graph.dto.AnalyticDto;
import com.example.graph.dto.AnalyticResDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AnalyticCustomRepository {

    List<AnalyticResDto> findTotalsByCollectedAtAndChannel();

    List<AnalyticDto> findDetailsByCollectedAtAndChannel(Set<LocalDate> collectedAtSet, Set<String> channelNameSet);

    List<AnalyticResDto> findTotalsWithVideos();
}
