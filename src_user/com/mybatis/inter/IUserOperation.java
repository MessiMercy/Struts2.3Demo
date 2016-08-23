package com.mybatis.inter;

import java.util.List;

import com.mybatis.User;

public interface IUserOperation {
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public void inserUser(User user);

	public void deleteUser(int id);

	public void updateUser(User user);

}
