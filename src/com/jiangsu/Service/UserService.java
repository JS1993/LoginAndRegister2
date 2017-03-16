package com.jiangsu.Service;

import com.jiangsu.domain.User;
import com.jiangsu.exception.UserExistException;

public interface UserService {
	/**
	 * ע���û�
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * ��½
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	public boolean findUserByName(String name) throws UserExistException;
}
