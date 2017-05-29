package com.cloud.tracker.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.tracker.entity.Issue;
import com.cloud.tracker.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	
	@RequestMapping("/list")
	public String listIssues(Model theModel) {
		
		//get the list of issues from the service layer
		List<Issue> issues = issueService.getIssues();
		
		//add it to the model
		theModel.addAttribute("issues",issues);
		
		//return the jsp page
		return "list-issues";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// get an issue object and pass that in as a model Attribute
		Issue issue = new Issue();
		theModel.addAttribute("issue",issue);
		return "issue-add";
	}

	@PostMapping("/saveIssue")
	public String saveIssue(@ModelAttribute("issue") Issue theIssue, Model theModel) {
		
		//call issue service layer to save to database
		issueService.saveIssue(theIssue);
		
		return "redirect:/issue/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("issueId") int issueId, Model theModel){
		
		Issue issue = issueService.getIssue(issueId);
		
		//add that issue to Model
		theModel.addAttribute("issue",issue);
		
		//return to the issue save screen
		return "issue-add";
		
	}
	
	@GetMapping("showFormForDelete")
	public String showFormForDelete(@RequestParam("issueId") int issueId, Model theModel){
		
		Issue issue = issueService.getIssue(issueId);
		
		//add that issue to Model
		issueService.deleteIssue(issue);
		
		//return to the issue save screen
		return "redirect:/issue/list";
		
	}
}
