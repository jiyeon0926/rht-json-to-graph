package com.example.graph.domain.analytic.repository;

import com.example.graph.domain.analytic.entity.Analytic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticRepository extends JpaRepository<Analytic, Long>, AnalyticCustomRepository {
}
