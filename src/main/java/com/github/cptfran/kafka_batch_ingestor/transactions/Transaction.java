package com.github.cptfran.kafka_batch_ingestor.transactions;

import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, name = "account_id")
	private long accountId;
	
	@Column(nullable = false)
	private Instant timestamp;

	@Column(nullable = false)
	private double amount;

	public enum TransactionType {
		DEPOSIT,
		WITHDRAWAL
	}
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	@Column(nullable = false, name = "is_suspicious")
	private boolean isSuspicious;

	public Transaction() {
		
	}

	public Transaction(long accountId, Instant timestamp, double amount, TransactionType type, boolean isSuspicious) {
		this.accountId = accountId;
		this.timestamp = timestamp;
		this.amount = amount;
		this.type = type;
		this.isSuspicious = isSuspicious;
	}

	public long getId() {
		return this.id;
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

	public void setTimegetTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return this.type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public boolean getIsSuspicious() {
		return this.isSuspicious;
	}

	public void setIsSuspicious(boolean isSuspicious) {
		this.isSuspicious = isSuspicious;
	}
}
