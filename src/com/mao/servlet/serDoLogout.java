package com.mao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 注销操作
 */
@SuppressWarnings("serial")
public class serDoLogout extends HttpServlet {

	
	public serDoLogout() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try{

				session.removeAttribute("teacher");
				session.removeAttribute("student");
	
		}catch(Exception e){e.printStackTrace();};
		response.sendRedirect("../Login.jsp");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
