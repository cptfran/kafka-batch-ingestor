package com.github.cptfran.kafka_batch_ingestor.daily_summary;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DailySummary {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false, name = "account_id")
	private long accountId;

	@Column(nullable = false)
	private LocalDate date;

	@Column(nullable = false, name = "total_amount")
	private long totalAmount;

	public DailySummary() {

	}

	public DailySummary(long accountId, LocalDate date, long totalAmount) {
		this.accountId = accountId;
		this.date = date;
		this.totalAmount = totalAmount;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public long getTotalAmoun() {
		return this.totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
}
