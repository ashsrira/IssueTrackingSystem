package com.cloud.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="issue")
public class Issue {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="is required")
	@Column(name="bouncer",nullable=false)
	private String bouncer;
	
	@NotNull(message="is required")
	@Column(name="issue",nullable=false)
	private String issue;
	
	@NotNull(message="is required")
	@Column(name="filing_date",nullable=false)
	private String filingDate;
	
	@NotNull(message="is required")
	@Column(name="owner",nullable=false)
	private String owner;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getBouncer() {
		return bouncer;
	}


	public void setBouncer(String bouncer) {
		this.bouncer = bouncer;
	}


	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}


	public String getFilingDate() {
		return filingDate;
	}


	public void setFilingDate(String filingDate) {
		this.filingDate = filingDate;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Issue [id=" + id + ", bouncer=" + bouncer + ", issue=" + issue + ", filingDate=" + filingDate
				+ ", owner=" + owner + "]";
	}
}
