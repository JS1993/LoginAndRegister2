package com.jiangsu.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.jiangsu.Service.UserService;
import com.jiangsu.Service.impl.UserServiceImpl;
import com.jiangsu.domain.User;
import com.jiangsu.domain.UserForm;
import com.jiangsu.exception.UserExistException;

public class RegServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡ������
		User user = new User();
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//���map�в�Ϊ�գ���˵���д�����Ϣ
		if(!uf.validate()){
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		//ע����������
		try {
			ConvertUtils.register(new Converter() {
				Date datex = null;
				@Override
				public Object convert(Class type, Object value) {
					if(value instanceof String){
						String date = (String)value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							datex = sdf.parse(date);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					return datex;
				}
			}, Date.class);
			BeanUtils .populate(user, request.getParameterMap());
			//����ҵ���߼�
			UserService us = new UserServiceImpl();
			//�ж��û��Ƿ��Ѿ�ע��
			boolean b = us.findUserByName(user.getName());
			us.register(user);
					
		}catch(UserExistException e){
			request.setAttribute("error", "�û����Ѵ���");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("ע��ɹ�!1s����ת��ҳ");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
