package com.app.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.beans.User;
import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;

public class DbOperations {
	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=ctx.getBean(UserDAO.class);
		
		/*
		 * User u=new User(); u.setUserId(1); u.setName("Omkar");
		 * u.setEmail("expertomkar@gmail.com"); u.setUserName("admin");
		 * u.setPassword("admin"); userDAO.save(u);
		 */
		List<User> ls=userDAO.findByProperty("name", "Omka");
		for(User u:ls){
			System.out.println(u.getName());
			System.out.println(u.getEmail());
			System.out.println();
		}
	}
}
