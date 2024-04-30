package com.example.demo.domain.repository;

import com.example.demo.domain.entity.DailySongEntity;
import com.example.demo.global.util.range.RangeableExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySongRepository extends JpaRepository<DailySongEntity, Long>, RangeableExecutor<DailySongEntity> {
}
