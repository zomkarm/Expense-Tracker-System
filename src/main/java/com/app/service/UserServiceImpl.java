package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.app.beans.User;
import com.app.dao.BaseDAO;
import com.app.dao.UserDAO;
import com.app.exception.UserBlockedException;
import com.app.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{

	@Autowired
	private UserDAO userDao;
	
	public void register(User u) {
		userDao.save(u);
	}

	public User login(String userName, String password) throws UserBlockedException {
		String sql="SELECT userId,name,email,userName,password from user where userName=:uname AND password=:pass";
		Map mp=new HashMap();
		mp.put("uname",userName);
		mp.put("pass", password);
		try {
			return getNamedParameterJdbcTemplate().queryForObject(sql, mp,new UserRowMapper());
		}catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
	
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean checkEmail(String email) {
		List<User> data=userDao.findByProperty("email", email);
		if(data.size()==0) 
			return false;
		else
			return true;
	}

}
