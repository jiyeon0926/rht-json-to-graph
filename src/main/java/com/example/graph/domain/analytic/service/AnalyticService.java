package com.example.graph.domain.analytic.service;

import com.example.graph.domain.analytic.dto.AnalyticSimpleResDto;
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

    @Transactional(readOnly = true)
    public List<AnalyticTotalsResDto> findTotalsWithVideos() {
        return analyticRepository.findTotalsWithVideos();
    }

    @Transactional(readOnly = true)
    public List<AnalyticSimpleResDto> findByCollectedAtAndChannel() {
        return analyticRepository.findByCollectedAtAndChannel();
    }
}
