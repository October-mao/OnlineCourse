package com.mao.servlet.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.mao.dao.DaoStu;
import com.mao.bean.Student;

@SuppressWarnings("serial")
public class serDoUpdateStu extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count = 0;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SmartUpload su =new SmartUpload();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this,request,response,null,true,8192,true);
		su.initialize(pageContext);
		su.setMaxFileSize(100000);
		su.setAllowedFilesList("jpg,JPG,gif");
		try {
			su.setDeniedFilesList("exe,bat,jsp,js,htm,html");
			su.upload();
			count = su.save("/images", su.SAVE_VIRTUAL);
			out.println(count+"个文件上传成功！<br>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i=0;i<su.getFiles().getCount();i++)
		{
			File file = su.getFiles().getFile(i);
			// 若文件不存在则继续
			if (file.isMissing()) continue;
		}
		int sno = Integer.parseInt(su.getRequest().getParameter("SNo"));
		String name = su.getRequest().getParameter("Sname");
		String password = su.getRequest().getParameter("Spassword");
		String sclass = su.getRequest().getParameter("Sclass");
		String sex = su.getRequest().getParameter("Ssex");
		String publishTime = su.getRequest().getParameter("publishTime");
		String sphoto = su.getFiles().getFile(0).getFileName();
		if (count==0){
			DaoStu daoStu = new DaoStu();
			Student stu = daoStu.selectStu(sno);
			sphoto = stu.getPhoto();
		}
		try{
			request.setCharacterEncoding("utf-8");
			Student stu = new Student(sno,name,password,sclass,sex,0,publishTime,sphoto);
			System.out.println(stu.toString());
			DaoStu update = new DaoStu();
			int rs = update.updateStu(stu);
			if(rs==0){
				out.println("<script>alert('修改失败！')</script>");
			}else{
				out.println("<script>alert('修改成功！')</script>");
			}
			response.setHeader("refresh","2;url=../tea/selectStu.jsp");
		}catch(Exception e){e.printStackTrace();}

		out.flush();
		out.close();

	}

	
}
