package com.github.cptfran.kafka_batch_ingestor.daily_summary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySummaryRepository extends JpaRepository<DailySummary, Long> {
	
}
