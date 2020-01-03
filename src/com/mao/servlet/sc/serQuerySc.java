package com.mao.servlet.sc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mao.dao.DaoQuery;
import com.mao.bean.QueryResult;
import com.mao.bean.Teacher;

public class serQuerySc extends HttpServlet {

	public serQuerySc() {
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
			response.sendRedirect("Login.jsp");
		}else{
			Teacher tea = (Teacher) session.getAttribute("teacher");

			try{
				request.setCharacterEncoding("utf-8");
				String queryKey = request.getParameter("queryKey");//查询关键字
				int type = 20;//查询类型，默认为20
				if(request.getParameter("type")!=null){
					type = Integer.parseInt(request.getParameter("type"));
				}
				DaoQuery query = new DaoQuery();
				List<QueryResult> list = new ArrayList<QueryResult>();
				switch(type){
				case 1:
					list = query.selectSno(Integer.parseInt(queryKey));break;//学号
				case 2:
					list = query.selectSname(queryKey);break;//姓名
				case 3:
					list = query.selectSclass(queryKey);break;//班级
				case 4:
					list = query.selectCname(queryKey);System.out.println("cname"+queryKey);break;//课程名
				case 5:
					list = query.selectCno(Integer.parseInt(queryKey));break;//课程号
				case 6:
					list = query.selectRoom(queryKey);break;//上课教室
				case 20:
					out.println("<center>请输入查询关键字，并选择查询类型</center>");break;
				default:
					out.println("<script>alert('错误，请重试！')</script>");break;
				}
				request.setAttribute("queryResult", list);
				request.getRequestDispatcher("../tea/Query.jsp?type="+type+"&key="+queryKey+"").forward(request, response);
			}catch(Exception e){response.sendRedirect("../tea/Query.jsp");e.printStackTrace();}

		}
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}

}
