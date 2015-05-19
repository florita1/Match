package com.project.match;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Locale locale, Model model) {
		logger.info("Client is at home.");
						
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		logger.info("User is registering.");
		
		return "register";
	}
	
	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String registered(HttpServletRequest request, HttpServletResponse response, Model model) throws SQLException {
		logger.info("User info is submitted to database.");
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String uName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String pass = request.getParameter("passWord");
		
		System.out.println(fName+lName+uName+age+email+pass);
		
		use.setFirst_name(fName);
		use.setLast_name(lName);
		use.setUser_name(uName);
		use.setAge(age);
		use.setGender(gender);
		use.setEmail(email);
		use.setPassword(pass);
		user.registerUser(use);
		HttpSession userSession = request.getSession();
		int userId = user.getId(uName);
		userSession.setAttribute("userName", uName);
		userSession.setAttribute("userId", userId);
		model.addAttribute("message", fName );
		
		return "registered";
	}
	
	@RequestMapping(value = "/questionnaire", method = RequestMethod.GET)
	public String questionnaire(Model model) {
		logger.info("User is answering questionnaire.");
		List<QuestionnaireTable> quest = questions.getQuestions();
		numOfQ = quest.size();
		model.addAttribute("questionList", quest);
		
		return "questionnaire";
	}
	
	@RequestMapping(value = "/submitAnswers", method = RequestMethod.POST)
	public String submitQuestionnaire(Model model, HttpServletRequest request) {
		logger.info("User answered questionnaire.");
		List<QuestionnaireTable> quest = questions.getQuestions();
		for(int x = 1; x <= numOfQ; x++) {
			String a = request.getParameter(Integer.toString(x));
			ans.setUser(use);
			ans.setQuestion(quest.get(x-1));
			ans.setAnswer(a);
			answer.setAnswers(ans);
		}
		
		return "submitAnswers";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String viewProfile(Model model, HttpServletRequest request) {
		logger.info("User is at their profile.");
		HttpSession userSession = request.getSession();
		int userId = (int) userSession.getAttribute("userId");
		User userInfo = user.getUser(userId);
		List<Answers> answers = answer.getAnswers(userInfo);
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("answerList", answers);
		model.addAttribute("method","get");
		return "profile";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String viewSelectedUserProfile(Model model, HttpServletRequest request) {
		logger.info("User selected a profile to view.");
		int userId = Integer.parseInt(request.getParameter("userId"));
		User userInfo = user.getUser(userId);
		List<Answers> answers = answer.getAnswers(userInfo);
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("answerList", answers);
		model.addAttribute("method","post");
		return "profile";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model, HttpServletRequest request) {
		logger.info("User is logging in");
		
		return "login";
	}
	
	@RequestMapping(value = "/thankyou", method = RequestMethod.POST)
	public String thankyou( HttpServletRequest request, Locale locale, Model model ) throws SQLException {
		logger.info("User is logging in.");
		HttpSession userSession = request.getSession();
		if(userSession.isNew()) {
			//please log in again
		} else {
			//user is logged in
		}
		
		String name = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		
		String passDB = user.getPassword(name);
		String message = "";
		if(passDB.equals(pass)) {
			message = "Thank you for logging in "+name+".<br> "
					+ "please answer this questionnaire <a href='/match/questionnaire'>here</a>.";
			int userId = user.getId(name);
			use = user.getUser(userId);
			userSession.setAttribute("userName", name);
			userSession.setAttribute("userId", userId);
		} else {
			message = "Login failed. Please try logging in again <a href='/match/login'> here</a>.";
		}
		
		model.addAttribute("loginMessage", message );
		
		return "thankyou";
	}
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String viewAllUsers(Model model) {
		logger.info("User is viewing all users.");
		List<User> users = user.getAllUsers();
		model.addAttribute("userList", users);
		
		return "allUsers";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model,HttpServletRequest request) {
		logger.info("User is setting search options.");
		
		return "search";
	}
	
	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
	public String searchUsers(Model model,HttpServletRequest request) {
		logger.info("User is viewing search results.");
		HttpSession userSession = request.getSession();
		
		String ageRange = request.getParameter("age");
		String gender = request.getParameter("gender");
		List<User> selectedUsers = user.searchUsers(ageRange, gender);
		
		int userId = (int) userSession.getAttribute("userId");
		User userInfo = user.getUser(userId);
		List<Answers> userAnswers = answer.getAnswers(userInfo);
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
		List<Answers> answers = answer.getAnswers(use);
		numOfQ = answers.size();
		model.addAttribute("userInfo", use);
		model.addAttribute("userAnswers", answers);
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
