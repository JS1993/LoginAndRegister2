package com.jiangsu.Dao;

import com.jiangsu.domain.User;

public interface UserDao {
	
	/**
	 * ����û�
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * �����û�������������û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	
	
	public boolean findUserByName(String name);
}
