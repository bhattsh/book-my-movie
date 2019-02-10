package com.cg.bookmymovie.ewallet.ewallet.ewallet;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="Statements")
public class Statement {
	
	@Id
	private Integer transactionId;
	   @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "profileId")
	   @JsonBackReference
	private Ewallet ewallet;
	private String transactionType;
	private Double amount;
	private String remarks;
	private LocalDateTime DateTime;
	
	static int transactionCount;    
	static {
		transactionCount = 1;
    }
    {
    	transactionId=transactionCount++;
    }

	
	
	public Statement(Ewallet ewallet, String transactionType, Double amount, String remarks, LocalDateTime dateTime) {
		super();
		this.ewallet = ewallet;
		this.transactionType = transactionType;
		this.amount = amount;
		this.remarks = remarks;
		DateTime = dateTime;
	}

	public Statement() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Ewallet getEwallet() {
		return ewallet;
	}

	public void setEwallet(Ewallet ewallet) {
		this.ewallet = ewallet;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getDateTime() {
		return DateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Statement [transactionId=" + transactionId + ", ewallet=" + ewallet + ", transactionType="
				+ transactionType + ", amount=" + amount + ", remarks=" + remarks + ", DateTime=" + DateTime + "]";
	}
}
