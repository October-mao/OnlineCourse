package com.mao.servlet.cou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mao.dao.DaoCou;

public class serDeleteCou extends HttpServlet {

	public serDeleteCou() {
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
			
			DaoCou delete = new DaoCou();
			int rs = delete.deleteCou(Integer.parseInt(request.getParameter("id")));
			if(rs==0){
				out.println("<script>alert('删除失败！')</script>");
			}else {
				out.println("<script>alert('删除成功！')</script>");
			}
			response.setHeader("refresh","2;url=../tea/selectCou.jsp");

			
		}catch(Exception e){e.printStackTrace();}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
