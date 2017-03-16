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
			if(u==null){//���Ϊ�գ��ֶ��׳��쳣
				throw new UsersException("�û������������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			//д����־
		}
		return u;
	}

	@Override
	public boolean findUserByName(String name) throws UserExistException {
		
		boolean b = userdao.findUserByName(name);
		if(b){
			throw new UserExistException("�û��Ѵ���");
		}		
		return b;
	}

	
	
}
