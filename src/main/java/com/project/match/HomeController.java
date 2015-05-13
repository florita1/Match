package com.project.match;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.project.model.Questions;
import com.project.model.User;
import com.project.service.MatchImplAnswers;
import com.project.service.IMatch;
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
		String email = request.getParameter("email");
		String pass = request.getParameter("passWord");
		
		System.out.println(fName+lName+uName+age+email+pass);
		
		User use = new User(fName,lName,uName,age,email,pass);
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
		Questionnaire ques = new Questionnaire();
		List questions = ques.getQuestions();
		numOfQ = questions.size();
		model.addAttribute("questionList", questions);
		
		return "questionnaire";
	}
	
	@RequestMapping(value = "/submitAnswers", method = RequestMethod.POST)
	public String submitQuestionnaire(Model model, HttpServletRequest request) {
		logger.info("User answered questionnaire.");
		HttpSession userSession = request.getSession();
		int userId = (int) userSession.getAttribute("userId");
		List<String> answers = new ArrayList<String>();
		for(int x = 1; x <= numOfQ; x++) {
			String answer = request.getParameter(Integer.toString(x));
			answers.add(answer);
//			if(answer.equals("y")) {
//				answers.add(true);
//			} else {
//				answers.add(false);
//			}
		}
		Questions q = new Questions(answers,userId);
		answer.setAnswers(q);
		return "submitAnswers";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String viewProfile(Model model, HttpServletRequest request) {
		logger.info("User is at their profile.");
		HttpSession userSession = request.getSession();
		int userId = (int) userSession.getAttribute("userId");
		List answers = answer.getAnswers(userId);
		User userInfo = user.getUser(userId);
		String fName = userInfo.getFirst_name();
		String lName = userInfo.getLast_name();
		int age = userInfo.getAge();
		model.addAttribute("userInfo", fName+lName+age);
		model.addAttribute("answerList", answers);
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
		
		String id = userSession.getId();

		String name = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		
		String passDB = user.getPassword(name);
		
		String message = "";
		if(passDB.equals(pass)) {
			message = "Thank you for logging in "+name+".<br> "
					+ "You can go to your profile <a href='/match/profile'> here</a>.";
		} else {
			message = "Login failed. Please try logging in again <a href='/match/login'> here</a>.";
		}
		int userId = user.getId(name);
		userSession.setAttribute("userName", name);
		userSession.setAttribute("userId", userId);
		model.addAttribute("loginMessage", message );
		
		return "thankyou";
	}
}
