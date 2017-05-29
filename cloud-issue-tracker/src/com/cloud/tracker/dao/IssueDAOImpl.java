package com.cloud.tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.tracker.entity.Issue;

@Repository
public class IssueDAOImpl implements IssueDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Issue> getIssues() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Issue> theQuery = currentSession.createQuery("from Issue order by filingDate",Issue.class);
		List<Issue> issues = theQuery.getResultList();
		return issues;
	}

	@Override
	public void saveIssue(Issue theIssue) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theIssue);
	}

	@Override
	public Issue getIssue(int issueId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Issue issue = currentSession.get(Issue.class, issueId);
		return issue;
	}

	@Override
	public void deleteIssue(Issue issue) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(issue);
	}
}
