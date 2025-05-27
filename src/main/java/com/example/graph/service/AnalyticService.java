package com.example.graph.service;

import com.example.graph.dto.AnalyticResDto;
import com.example.graph.repository.AnalyticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticService {

    private final AnalyticRepository analyticRepository;

    @Transactional(readOnly = true)
    public List<AnalyticResDto> findTotalsByChannelAndCollectedAt() {
        return analyticRepository.findTotalsByChannelAndCollectedAt();
    }
}
