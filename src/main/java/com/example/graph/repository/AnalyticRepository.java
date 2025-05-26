package com.example.graph.repository;

import com.example.graph.entity.Analytic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticRepository extends JpaRepository<Analytic, Long> {
}
