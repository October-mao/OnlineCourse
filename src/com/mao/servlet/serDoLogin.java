package com.mao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mao.dao.DaoStu;
import com.mao.dao.DaoTea;
import com.mao.bean.Student;
import com.mao.bean.Teacher;

@SuppressWarnings("serial")
public class serDoLogin extends HttpServlet {


	public serDoLogin() {
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
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try{
			int username = Integer.parseInt(request.getParameter("username"));
			String password = request.getParameter("password");
			String type  = null;
			if(request.getParameter("type")!=null)
				type = request.getParameter("type");
			if(type.equals("tea")){//判断是否为老师
				Teacher tea = new Teacher(username,null,password);
				DaoTea logint = new DaoTea();
				tea = logint.loginTea(tea);
				if(tea!=null){
					session.setAttribute("teacher", tea);
					response.sendRedirect("../tea/teacher.jsp");
				}else{
					out.println("<script>alert('用户名或密码不正确，请核对后重试!!')</script>");
					response.setHeader("refresh","1;url=../tea/teaLogin.jsp");
				}
			}else if(type.equals("stu")){	//判断是否为学生
				Student stu = new Student(username,null,password,null,null,0,null,null);
				DaoStu logins  = new DaoStu();
				stu = logins.loginStu(stu);
				if(stu!=null){
					session.setAttribute("student", stu);
					response.sendRedirect("../stu/student.jsp");
				}else{
					out.println("<script>alert('用户名或密码不正确，请核对后重试!!!')</script>");
					response.setHeader("refresh","1;url=../Login.jsp");
				}
			}else{
				out.println("<script>alert('错误，请重新登入!!!')</script>");
				response.setHeader("refresh","1;url=../Login.jsp");
			}
		}catch(Exception e){ e.printStackTrace();response.sendRedirect("../Login.jsp");}
		out.flush();
		out.close();
		}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
