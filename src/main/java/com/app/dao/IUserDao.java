package com.app.dao;

import com.app.model.User;

public interface IUserDao {

	public void saveUser(User user);
	public User findByUserEmail(String userName);
}
