package com.cloud.tracker.service;

import java.util.List;

import com.cloud.tracker.entity.Issue;

public interface IssueService {
	public List<Issue> getIssues();
	public void saveIssue(Issue theIssue);
	public Issue getIssue(int issueId);
	public void deleteIssue(Issue issue);

}
