<%@ page language="java" import="java.util.*,com.mao.dao.*,com.mao.bean.Student,com.mao.bean.SedCou" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-显示学生个人信息</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
<%
	Student stu = null;
	if(session.getAttribute("student")==null){
		response.sendRedirect("Login.jsp");
	}else{
		stu = (Student)session.getAttribute("student");%>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=images/<%=stu.getPhoto()%> width="120" height="120"></div>
		<div class="main_left_class01"><a href="stu/choiceCou.jsp">学生选课</a></div>
		<div class="main_left_class02"><a href="stu/showCou.jsp">课程查询</a></div>
		<div class="main_left_class03"><a href="stu/stuInfo.jsp">学籍信息</a></div>
		<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('servlet/serDoLogout')">
		</div>
	</div>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= stu.getSname() %>同学，你好！！！</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			<div class="form_1">
				<table class="info">
				<%
			  			DaoStu select1 = new DaoStu();
			   		%>
  					<tr><td></td></tr>
  					<tr><td></td><td><input class="text" type="text" value="<%= stu.getSname() %>" readonly="true"></td><td></td><td></td><td></td>
						<td rowspan="2"><img src="images/<%=stu.getPhoto()%>"  width="120" height="120"/></td></tr>
  					<tr><td></td><td><input class="text" type="text" value="学号：<%= stu.getSNo() %>" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="密码：<%= stu.getSpassword() %>" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="性别：<%= stu.getSsex() %>" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="班级：<%= stu.getSclass() %>" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="注册时间：<%= stu.getPublishTime() %>" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="总学分：<%= select1.selectScre(stu).getScredit() %>" readonly="true"></td>
  					</tr>
		  				<%
		   			}
		    %>
  				</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>