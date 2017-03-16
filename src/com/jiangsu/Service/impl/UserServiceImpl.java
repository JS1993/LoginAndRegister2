package com.jiangsu.Service.impl;

import com.jiangsu.Dao.UserDao;
import com.jiangsu.Dao.impl.UserDaoImpl;
import com.jiangsu.Service.UserService;
import com.jiangsu.domain.User;
import com.jiangsu.exception.UserExistException;
import com.jiangsu.exception.UsersException;

public class UserServiceImpl implements UserService {

	UserDao userdao = new UserDaoImpl();
	@Override
	public void register(User user) throws Exception {
		userdao.addUser(user);
	}
	
	@Override
	public User login(User user) {
		User u = null;
		try {
			u = userdao.findUser(user);
			if(u==null){//如果为空，手动抛出异常
				throw new UsersException("用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			//写入日志
		}
		return u;
	}

	@Override
	public boolean findUserByName(String name) throws UserExistException {
		
		boolean b = userdao.findUserByName(name);
		if(b){
			throw new UserExistException("用户已存在");
		}		
		return b;
	}

	
	
}
