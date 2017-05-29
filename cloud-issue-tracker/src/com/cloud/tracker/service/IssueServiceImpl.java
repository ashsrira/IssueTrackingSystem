package com.cloud.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.tracker.dao.IssueDAO;
import com.cloud.tracker.entity.Issue;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDAO issueDAO;
	
	@Override
	@Transactional
	public List<Issue> getIssues() {
		
		// use the autowired DAO IMPL to get the list of issue
		List<Issue> issues = issueDAO.getIssues();
		return issues;
	}

	@Override
	@Transactional
	public void saveIssue(Issue theIssue) {
		// use the issue DAO Layer to save to database
		issueDAO.saveIssue(theIssue);
	}

	@Override
	@Transactional
	public Issue getIssue(int issueId) {
		//use the  DAO Layer to get the issue from the database
		
		Issue issue = issueDAO.getIssue(issueId);
		return issue;
	}

	@Override
	@Transactional
	public void deleteIssue(Issue issue) {
		//use the  DAO Layer to delete the issue from the database
		issueDAO.deleteIssue(issue);
	}
}
