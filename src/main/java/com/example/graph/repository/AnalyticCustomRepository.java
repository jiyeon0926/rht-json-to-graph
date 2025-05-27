package com.example.graph.repository;

import com.example.graph.dto.AnalyticResDto;

import java.util.List;

public interface AnalyticCustomRepository {

    List<AnalyticResDto> findTotalsByChannelAndCollectedAt();
}
