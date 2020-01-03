package com.mao.servlet.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mao.dao.DaoSc;
import com.mao.bean.SC;

public class serDoUpdateClass extends HttpServlet {

	public serDoUpdateClass() {
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

		HttpSession session = request.getSession();
		if(session.getAttribute("teacher")==null){
			response.sendRedirect("../Login.jsp");
		}else{

			try{
				int sno = Integer.parseInt(request.getParameter("sno"));
				int cno = Integer.parseInt(request.getParameter("cno"));
			String classroom = request.getParameter("classroom");
			DaoSc update = new DaoSc();
			SC sc = new SC();
			sc.setSNo(sno);
			sc.setCNo(cno);
			sc.setClassroom(classroom);
			int rs = update.updateClass(sc);
			if(rs!=0) {
				out.println("<script>alert('教室修改成功！')</script>");
			}else{
				out.println("<script>alert('教室修改失败，请重试！')</script>");
			}
			response.setHeader("refresh","2;url=../tea/Query.jsp?type="+request.getParameter("type")+"&query="+request.getParameter("key")+"");
		}catch(Exception e){e.printStackTrace();}

		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
