package com.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.beans.User;
import com.app.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	public void save(User u) {

		String sql="INSERT iNTO user(name,email,userName,password) VALUES (:name,:email,:userName,:password)";
		Map m=new HashMap();
		m.put("name",u.getName());
		m.put("email",u.getEmail());
		m.put("userName",u.getUserName());
		m.put("password",u.getPassword());
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps =new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
		Integer userId=kh.getKey().intValue();
		u.setUserId(userId);
		
	}

	public void update(User u) {
		String sql="UPDATE user SET name=:name,email=:email,userName=:userName,password=:password where userId=:userId";
		Map m=new HashMap();
		m.put("name",u.getName());
		m.put("email",u.getEmail());
		m.put("userName",u.getUserName());
		m.put("password",u.getPassword()); 
		m.put("name",u.getName());
		m.put("userId",u.getUserId());
		
		super.getNamedParameterJdbcTemplate().update(sql,m);
	}

	public void delete(User u) {
		this.delete(u.getUserId());
	}

	public void delete(Integer userId) {
		String sql="DELETE FROM user where userId=?";
		getJdbcTemplate().update(sql,userId);
	
	}
	
	public User findById(Integer userId) {
		String sql="SELECT * FROM user WHERE userId=?";
		User u=getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		return u;
	}

	public List<User> findAll() {
		String sql="SELECT * FROM user";
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propName, Object propValue) {
		String sql="SELECT * FROM user WHERE "+propName+"=?";
		return getJdbcTemplate().query(sql, new UserRowMapper(),propValue);
	}


}
