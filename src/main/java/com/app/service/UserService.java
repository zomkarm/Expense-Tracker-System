package com.app.service;

import java.util.List;

import com.app.beans.User;
import com.app.exception.UserBlockedException;

public interface UserService {
	public void register(User u);
	public User login(String userName,String password) throws UserBlockedException;
	public List<User> getUserList();
	public boolean checkEmail(String email);
}
