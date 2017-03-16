package com.jiangsu.Service;

import com.jiangsu.domain.User;
import com.jiangsu.exception.UserExistException;

public interface UserService {
	/**
	 * ×¢²áÓÃ»§
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * µÇÂ½
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	public boolean findUserByName(String name) throws UserExistException;
}
