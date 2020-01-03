package com.mao.servlet.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mao.dao.DaoCou;
import com.mao.dao.DaoSc;
import com.mao.dao.DaoStu;
import com.mao.bean.Student;
import com.mao.bean.SC;

public class serInsertSc extends HttpServlet {

	public serInsertSc() {
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
		if (session.getAttribute("student") == null) {
			response.sendRedirect("../Login.jsp");
		} else {
			stu = (Student) session.getAttribute("student");
		}
			try {
				String choiceR[] = request.getParameterValues("checkAll");
				DaoStu selects = new DaoStu();
				DaoCou selectc = new DaoCou();
				Student stu2 = selects.selectScre(stu);
				float scredit = stu2.getScredit();//学生已经选到的学分数
				int sno = stu.getSNo();
				if (choiceR.length != 0) {
					SC sc[] = new SC[choiceR.length];
					for (int i = 0; i < choiceR.length; i++) {
						int classroom = (int) ((Math.random()*20)+200);
						sc[i] = new SC();
						sc[i].setSNo(sno);
						sc[i].setCNo(Integer.parseInt(choiceR[i]));
						sc[i].setClassroom(String.valueOf(classroom));//默认为随机教室
						scredit += selectc.selectScre(sc[i].getSNo());//学生待选课程+学生已选课程学分
					}
					System.out.println(scredit);
					if (scredit <= Student.MAXscore) {
						DaoSc insert = new DaoSc();
						int rs[] = insert.insertSc(sc), sum = 0;
						for (int i = 0; i < rs.length; i++) {
							if (rs[i] == 0) System.out.println("rs" + i + "is null  !!");
							sum += rs[i];
						}
						if (sum != 0) {
							out.println("<script>alert('选课成功！')</script>");
							response.setHeader("refresh", "1;url=../stu/showCou.jsp");
						}
					} else {
						out.println("<script>alert('你选择的课程超过上限！')</script>");
						response.setHeader("refresh", "1;url=../stu/choiceCou.jsp");
					}
				} else {
					out.println("<script>alert('未选择课程！')</script>");
					response.setHeader("refresh", "1;url=../stu/choiceCou.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<script>alert('选课失败！')</script>");
				response.setHeader("refresh", "1;url=../stu/choiceCou.jsp");
			}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
