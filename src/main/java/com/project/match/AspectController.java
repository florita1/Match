package com.project.match;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.Answers;
import com.project.model.QuestionnaireTable;
import com.project.model.User;
import com.project.service.MatchImplAnswers;
import com.project.service.MatchImplUsers;
import com.project.service.Questionnaire;

@Controller
public class AspectController {
	
	private static final Logger logger = LoggerFactory.getLogger(AspectController.class);
	
	@Autowired
	private MatchImplUsers user;
	
	@Autowired
	private MatchImplAnswers answer;
	
	@Autowired
	private Questionnaire questions;
	
	@Autowired
	private Answers ans;
	
	@Autowired
	private User use;
	
	private int numOfQ;
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String viewSelectedUserProfile(Model model, HttpServletRequest request) {
		logger.info("User selected a profile to view.");
		int userId = Integer.parseInt(request.getParameter("userId"));
		User userInfo = user.getUser(userId);
		List<Answers> answers = answer.getAnswers(userInfo);
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("answerList", answers);
		model.addAttribute("method","post");
		model.addAttribute("Authenticated", "yes");
		return "profile";
	}
	
	
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String viewAllUsers(Model model, HttpServletRequest request) {
		logger.info("User is viewing all users.");
		HttpSession userSession = request.getSession();
		if(userSession.getAttribute("Authen")==null || userSession.isNew()) {
			String msg = "You must be logged in to view all users.";
			model.addAttribute("loginMessage", msg);
			model.addAttribute("Authenticated", "no");
		} else {
			model.addAttribute("Authenticated", "yes");
			List<User> users = user.getAllUsers();
			model.addAttribute("userList", users);
		}
		return "allUsers";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model,HttpServletRequest request) {
		logger.info("User is setting search options.");
		HttpSession userSession = request.getSession();
		if(userSession.getAttribute("Authen")==null || userSession.isNew()) {
			String msg = "You must be logged in to search profiles.";
			model.addAttribute("loginMessage", msg);
			model.addAttribute("Authenticated", "no");
		} else {
			model.addAttribute("Authenticated", "yes");
		}
		
		return "search";
	}
	
	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
	public String searchUsers(Model model,HttpServletRequest request) {
		logger.info("User is viewing search results.");
		HttpSession userSession = request.getSession();
		
		String ageRange = request.getParameter("age");
		String gender = request.getParameter("gender");
		List<User> selectedUsers = user.searchUsers(ageRange, gender);
		
		use = (User) userSession.getAttribute("user");
		List<Answers> userAnswers = answer.getAnswers(use);
		for(User match : selectedUsers) {
			List<Answers> matchAnswers = answer.getAnswers(match);
			int percentage = answer.getPercentage(userAnswers, matchAnswers);
			match.setPercentage(percentage);
		}
		model.addAttribute("userList", selectedUsers);
		return "searchUsers";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request) {
		logger.info("User is editing their profile.");
		HttpSession userSession = request.getSession();
		if(userSession.getAttribute("Authen")==null || userSession.isNew()) {
			String msg = "You must be logged in to edit your profile.";
			model.addAttribute("loginMessage", msg);
			model.addAttribute("Authenticated", "no");
		} else {
			model.addAttribute("Authenticated", "yes");
			use = (User) userSession.getAttribute("user");
			List<Answers> answers = answer.getAnswers(use);
			numOfQ = answers.size();
			model.addAttribute("userInfo", use);
			model.addAttribute("userAnswers", answers);
		}
		return "edit";
	}
	
	@RequestMapping(value = "/submitEdit", method = RequestMethod.POST)
	public String submitEdit(Model model, HttpServletRequest request) {
		logger.info("Edits to user profile are being submitted.");
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		System.out.println(fName+lName+age+email);
		
		use.setFirst_name(fName);
		use.setLast_name(lName);
		use.setAge(age);
		use.setEmail(email);
		user.editUser(use);

		List<QuestionnaireTable> quest = questions.getQuestions();
		for(int x = 1; x <= numOfQ; x++) {
			String a = request.getParameter(Integer.toString(x));
			ans.setUser(use);
			ans.setQuestion(quest.get(x-1));
			ans.setAnswer(a);
			answer.editAnswers(ans);
		}
		
		return "submitEdit";
	}
}
