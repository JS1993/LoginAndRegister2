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
	 * �û������������룬3-8λ��ĸ���
	 * ���룺�������룬3-8Ϊ�������
	 * ȷ�����룺�������룬�����뱣��һ��
	 * ���䣺�������룬�ҷ��������ʽ
	 * ���գ��������룬����yyyy-MM-dd��ʽ
	 */
	
	public boolean validate(){
		if("".equals(name)){
			msg.put("name", "�û�������Ϊ�գ�");
		}else if(!name.matches("\\w{3,8}")){
			msg.put("name", "�û���Ϊ��3-8λ��ĸ���");
		}
		
		if("".equals(password)){
			msg.put("password", "���벻��Ϊ�գ�");
		}else if(!password.matches("\\d{3,8}")){
			msg.put("password", "����Ϊ��3-8λ��ĸ���");
		}
		
		if(!password.equals(repassword)){
			msg.put("repassword", "�������벻һ�¿գ�");
		}
		
		if("".equals(email)){
			msg.put("email", "���䲻��Ϊ�գ�");
		}else if(!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")){
			msg.put("email", "�����ʽ����ȷ��");
		}
		
		if("".equals(birthday)){
			msg.put("birthday", "���ղ���Ϊ�գ�");
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				msg.put("birthday", "���ո�ʽ����ȷ��");
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
