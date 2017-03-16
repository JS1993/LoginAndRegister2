package com.jiangsu.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private int id;
	private String name;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	
	Map<String,String> msg = new HashMap<String,String>();
	
	/*
	 * 用户名：必须输入，3-8位字母组成
	 * 密码：必须输入，3-8为数字组成
	 * 确认密码：必须输入，和密码保持一致
	 * 邮箱：必须输入，且符合邮箱格式
	 * 生日：必须输入，符合yyyy-MM-dd格式
	 */
	
	public boolean validate(){
		if("".equals(name)){
			msg.put("name", "用户名不能为空！");
		}else if(!name.matches("\\w{3,8}")){
			msg.put("name", "用户名为：3-8位字母组成");
		}
		
		if("".equals(password)){
			msg.put("password", "密码不能为空！");
		}else if(!password.matches("\\d{3,8}")){
			msg.put("password", "密码为：3-8位字母组成");
		}
		
		if(!password.equals(repassword)){
			msg.put("repassword", "两次密码不一致空！");
		}
		
		if("".equals(email)){
			msg.put("email", "邮箱不能为空！");
		}else if(!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")){
			msg.put("email", "邮箱格式不正确！");
		}
		
		if("".equals(birthday)){
			msg.put("birthday", "生日不能为空！");
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				msg.put("birthday", "生日格式不正确！");
				e.printStackTrace();
			}
		}
		
		return msg.isEmpty();
		
	}
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
	
}
