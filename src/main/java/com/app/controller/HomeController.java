package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.beans.User;
import com.app.command.UserCommand;
import com.app.dao.UserDAO;
import com.app.dao.UserDAOImpl;
import com.app.exception.UserBlockedException;
import com.app.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService; 
	
	@RequestMapping(value= {"/"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageTitle", "Homepage");
		mv.addObject("pageName", "content");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value= {"/login"})
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("login",new UserCommand());
		mv.addObject("pageTitle", "Login");
		mv.addObject("pageName", "login");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value= {"/register"})
	public ModelAndView register() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageTitle", "Register");
		mv.addObject("pageName", "register");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value= {"/reg_form"},method=RequestMethod.POST)
	public ModelAndView registerfForm(User u) {
		ModelAndView mv=new ModelAndView();
		
		if(userService.checkEmail(u.getEmail())) {
			mv.addObject("pageErrorMsg","Email Already Exists....");
		}else {
			userService.register(u);
			mv.addObject("pageSuccessMsg","Registered Successfully");
		}
		mv.addObject("pageTitle", "Register");
		mv.addObject("pageName", "register");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value= {"/user_login"},method=RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("login") UserCommand cmd,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		
		try {
			User loggedInUser=userService.login(cmd.getUserName(),cmd.getPassword());
			System.out.println(loggedInUser);
			if(loggedInUser!=null){
				System.out.println("success");
				addUserInSession(loggedInUser, session);
				mv.addObject("pageTitle", "DashBoard");
				mv.addObject("pageName", "content");
				mv.setViewName("user/dashboard");
				return mv;
			}
		} catch (UserBlockedException e) {
			mv.addObject("pageErrorMsg",e.getMessage());
		}
		System.out.println("fail");

		mv.addObject("pageErrorMsg","Invalid Credentials....s");		
		mv.addObject("pageTitle", "Login");
		mv.addObject("pageName", "login");
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping(value= {"/dashboard"})
	public ModelAndView dashboard() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageTitle", "DashBoard");
		mv.addObject("pageName", "content");
		mv.setViewName("user/dashboard");
		return mv;
	}
	
	@RequestMapping(value= {"/logout"})
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("login",new UserCommand());
		
		removeUserFromSession(session);
		mv.addObject("pageTitle", "Login");
		mv.addObject("pageName", "login");
		mv.setViewName("index");
		return mv;
	}
	
	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
	}
	
	private void removeUserFromSession(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("userId");
	}
	
	
}
