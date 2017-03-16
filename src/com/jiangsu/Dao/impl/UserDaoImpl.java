package com.jiangsu.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.jiangsu.Dao.UserDao;
import com.jiangsu.domain.User;
import com.jiangsu.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = DBUtils.getConnection();
			ps=conn.prepareStatement("INSERT INTO users(NAME,PASSWORD,email,birthday) VALUES(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(4, fr.format(user.getBirthday()));
		
			int status = ps.executeUpdate();
	    }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, ps, conn);
		}
	}

	@Override
	public User findUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		User userx = null;
		try{
			conn = DBUtils.getConnection();
			ps=conn.prepareStatement("select * from users where name=? and password=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
		
			if(rs.next()){
				userx = new User();
				userx.setId(rs.getInt(1));
				userx.setName(rs.getString(2));
				userx.setPassword(rs.getString(3));
				userx.setEmail(rs.getString(4));
				userx.setBirthday(rs.getDate(5));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return userx;
	}

	@Override
	public boolean findUserByName(String name) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		try{
			conn = DBUtils.getConnection();
			ps=conn.prepareStatement("select * from users where name=?");
			ps.setString(1, name);
			rs=ps.executeQuery();
		
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}
    
}
