package com.mao.servlet.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mao.dao.DaoSc;
import com.mao.bean.Student;

@SuppressWarnings("serial")
public class serDeleteSc extends HttpServlet {

	public serDeleteSc() {
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
		Student stu = null;
		if(session.getAttribute("student")==null){
			response.sendRedirect("../Login.jsp");
		}else{
			stu = (Student) session.getAttribute("student");
			response.setContentType("text/html;charset=utf-8");
			try{
				int sno = stu.getSNo();
				int cno = Integer.parseInt(request.getParameter("cno"));
				DaoSc delete = new DaoSc();
				int rs = delete.deleteSc(sno, cno);
				if(rs!=0) {
					out.println("<script>alert('成功取消选课！')</script>");
				} else {
					out.println("<script>alert('选课失败，请重新尝试！')</script>");
				}
				response.setHeader("refresh","1;url=../stu/showCou.jsp");
			}catch(Exception e){e.printStackTrace();}
		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
