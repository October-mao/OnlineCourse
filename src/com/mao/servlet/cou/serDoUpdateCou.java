package com.mao.servlet.cou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mao.dao.DaoCou;
import com.mao.bean.Course;

public class serDoUpdateCou extends HttpServlet {

	public serDoUpdateCou() {
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
			Course cou = new Course(Integer.parseInt(request.getParameter("CNo")),request.getParameter("Cname"),request.getParameter("Ccredit"));
			DaoCou update = new DaoCou();
			int rs = update.updateCou(cou);
			if(rs!=0){
				out.println("<script>alert('修改成功！')</script>");
			}else{
				out.println("<script>alert('修改失败！')</script>");
			}
			response.setHeader("refresh","1;url=../tea/selectCou.jsp");
		}catch(Exception e){e.printStackTrace();}
		

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}