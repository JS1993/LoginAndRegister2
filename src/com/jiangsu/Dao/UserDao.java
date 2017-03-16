package com.jiangsu.Dao;

import com.jiangsu.domain.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	
	
	public boolean findUserByName(String name);
}
