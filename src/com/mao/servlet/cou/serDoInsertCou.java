package com.mao.servlet.cou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mao.bean.SC;
import com.mao.dao.DaoCou;
import com.mao.bean.Course;

public class serDoInsertCou extends HttpServlet {

	public serDoInsertCou() {
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
			request.setCharacterEncoding("utf-8");
			Course cou = new Course(request.getParameter("Cname"),request.getParameter("Ccredit"));
			DaoCou insert = new DaoCou();
			int rs = insert.insertCou(cou);
			if(rs!=0){
				out.println("<script>alert('添加成功！')</script>");
			}else{
				out.println("<script>alert('添加失败！')</script>");
			}
			response.setHeader("refresh","1;url=../tea/selectCou.jsp");
		}catch(Exception e){e.printStackTrace();}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
