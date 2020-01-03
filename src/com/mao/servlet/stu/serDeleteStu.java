package com.mao.servlet.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mao.dao.DaoStu;

@SuppressWarnings("serial")
public class serDeleteStu extends HttpServlet {

	public serDeleteStu() {
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
		PrintWriter out = response.getWriter();
		try{
			
			DaoStu delete = new DaoStu();
			int rs = delete.deleteStu(Integer.parseInt(request.getParameter("id")));
			if(rs==0){
				out.println("<script>alert('删除失败！')</script>");
				response.setHeader("refresh","1;url=../tea/selectStu.jsp");
			}else {
				out.println("<script>alert('删除成功！')</script>");
				response.setHeader("refresh","1;url=../tea/selectStu.jsp");
			}
		}catch(Exception e){e.printStackTrace();}

	}
	public void init() throws ServletException {
		// Put your code here
	}

}
