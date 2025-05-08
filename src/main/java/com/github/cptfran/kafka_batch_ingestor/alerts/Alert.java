package com.github.cptfran.kafka_batch_ingestor.alerts;

import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Alert {
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, name = "transaction_id")
	private long transactionId;

	@Column(nullable = false, name = "account_id")
	private long accountId;

	@Column(nullable = false)
	private Instant timestamp;
	
	public enum AlertType {
		AMOUNT_THRESHOLD
	}
	@Column(nullable = false, name = "alert_type")
	@Enumerated(EnumType.STRING)
	private AlertType alertType;

	@Column(nullable = false)
	private String message;

	public Alert() {

	}

	public Alert(long transactionId, long accountId, Instant timestamp, AlertType alertType, String message) {
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.timestamp = timestamp;
		this.alertType = alertType;
		this.message = message;
	}

	public long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Instant getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public AlertType getAlertType() {
		return this.alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
