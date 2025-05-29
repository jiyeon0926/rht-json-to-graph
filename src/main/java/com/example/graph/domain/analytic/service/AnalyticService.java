package com.example.graph.domain.analytic.service;

import com.example.graph.domain.analytic.dto.AnalyticResDto;
import com.example.graph.domain.analytic.dto.AnalyticTotalsResDto;
import com.example.graph.domain.analytic.repository.AnalyticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticService {

    private final AnalyticRepository analyticRepository;

    // 각 채널에 대한 영상 상세 조회
    @Transactional(readOnly = true)
    public List<AnalyticResDto> findByCollectedAtAndChannel() {
        return analyticRepository.findByCollectedAtAndChannel();
    }

    // 집계 정보 및 영상 상세 조회
    @Transactional(readOnly = true)
    public List<AnalyticTotalsResDto> findTotalsWithVideos() {
        return analyticRepository.findTotalsWithVideos();
    }
}
