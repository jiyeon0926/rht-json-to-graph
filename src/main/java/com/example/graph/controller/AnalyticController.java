package com.example.graph.controller;

import com.example.graph.dto.AnalyticResDto;
import com.example.graph.service.AnalyticService;
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

    private final AnalyticService analyticService;

    @GetMapping
    public ResponseEntity<List<AnalyticResDto>> findTotalsWithVideos() {
        List<AnalyticResDto> analytics = analyticService.findTotalsWithVideos();

        return new ResponseEntity<>(analytics, HttpStatus.OK);
    }
}