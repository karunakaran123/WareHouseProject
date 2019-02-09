package com.app.service;

import com.app.model.User;

public interface IUserService {

	public void saveUser(User user);
	public User findByUserEmail(String uemail);
}
