package com.example.graph.domain.analytic.controller;

import com.example.graph.domain.analytic.dto.AnalyticResDto;
import com.example.graph.domain.analytic.dto.AnalyticTotalsResDto;
import com.example.graph.domain.analytic.service.AnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticController {

    @GetMapping
    public ResponseEntity<List<AnalyticResDto>> findByCollectedAtAndChannel() {
        List<AnalyticResDto> analytics = analyticService.findByCollectedAtAndChannel();

        return new ResponseEntity<>(analytics, HttpStatus.OK);
    }

    private final AnalyticService analyticService;

    @GetMapping("/totals")
    public ResponseEntity<List<AnalyticTotalsResDto>> findTotalsWithVideos() {
        List<AnalyticTotalsResDto> analytics = analyticService.findTotalsWithVideos();

        return new ResponseEntity<>(analytics, HttpStatus.OK);
    }
}