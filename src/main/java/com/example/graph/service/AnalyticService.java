package com.example.graph.service;

import com.example.graph.dto.AnalyticResDto;
import com.example.graph.entity.Analytic;
import com.example.graph.repository.AnalyticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticService {

    private final AnalyticRepository analyticRepository;

    @Transactional(readOnly = true)
    public List<AnalyticResDto> getAnalytics() {
        List<Analytic> analytics = analyticRepository.findAll();

        return analytics.stream()
                .map(analytic -> new AnalyticResDto(
                        analytic.getId(),
                        analytic.getSubscribers(),
                        analytic.getImpressionClickRate()))
                .collect(Collectors.toList());
    }
}
