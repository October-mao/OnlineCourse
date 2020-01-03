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

public class serUpdateClass extends HttpServlet {

	public serUpdateClass() {
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
				
				DaoSc update = new DaoSc();	
				SC sc = update.selectone(sno,cno);
				if(sc!=null){
					request.setAttribute("room", sc);
					request.getRequestDispatcher("../tea/updateRoom.jsp?type="+request.getParameter("type")+"&key="+request.getParameter("key")+"").forward(request, response);
				}else{
					out.println("<script>alert('查询失败，请稍后重试！')</script>");
					response.setHeader("refresh",  "1;url=serQuerySc");
				}
			}catch(Exception e){e.printStackTrace();}
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
