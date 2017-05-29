package com.cloud.tracker.dao;

import java.util.List;

import com.cloud.tracker.entity.Issue;

public interface IssueDAO {
	public List<Issue> getIssues();
	public void saveIssue(Issue theIssue);
	public Issue getIssue(int issueId);
	public void deleteIssue(Issue issue);
}
