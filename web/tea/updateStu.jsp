<%@ page language="java" import="java.util.*,com.mao.dao.*,com.mao.bean.*" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-修改学生信息</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <meta http-equiv="Content-Type" content="text/html;charset=gb2312" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script  type="text/javascript" src="js/setDate.js" charset="gb2312">
	</script>
  </head>
  
  <body>
  <%	
  		Teacher tea = null;
		if(session.getAttribute("teacher")==null){
			response.sendRedirect("/Ten/Login.jsp");
		}else{
			tea = (Teacher) session.getAttribute("teacher");
		}
   %>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
			<div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class03"><a href="tea/Query.jsp">信息查询</a></div>
			<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('servlet/serDoLogout')">
		</div>
	</div>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= tea.getTname() %>老师，您好！！！</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			<div class="form_1">
				<form action="servlet/serDoUpdateStu" method="post" enctype="multipart/form-data">
				 <%
				 DaoStu selectone = new DaoStu();
				Student stu = selectone.selectStu(Integer.parseInt(request.getParameter("id")));
				if(stu!=null){
				  %>
				<table>
				
  					<tr><td></td></tr>
					<tr><td>学生头像</td> <td>
						<input  type="file" name="file1" size="25">
					</td></tr>
  					<tr><td>学生学号</td> <td><input  class="text" type="text" name="SNo" value="<%= stu.getSNo() %>" readonly="true"/></td></tr>
  					<tr><td>学生姓名</td> <td><input  class="text" type="text" name="Sname" value="<%= stu.getSname() %>"/></td></tr>
  					<tr><td>学生密码</td> <td><input  class="text" type="text" name="Spassword" value="<%= stu.getSpassword() %>"/></td></tr>
  					<tr><td>学生班级</td> <td><input  class="text" type="text" name="Sclass" value="<%= stu.getSclass() %>"/></td></tr>
  					<tr><td>学生性别</td> <td><input  class="text" type="text" name="Ssex" value="<%= stu.getSsex() %>"/></td></tr>
					<tr><td>修改日期</td> <td><input type="text" readonly="readonly" style="cursor: hand" name="publishTime" size="15" onclick="HS_setDate(publishTime)">
						<img src="img/dateicon.jpg" onclick="HS_setDate(publishTime)" width=20 height=20></td></tr>
  					<tr><td></td><td><input class="btn" type="submit" value="确认修改"/> <input class="btn" type="reset" value="取消修改"/>  </td></tr>
 
			  		<%
			   			}else {request.getRequestDispatcher("tea/selectStu.jsp").forward(request, response);}
			   		%>
  					
  				</table>
  				</form>
  				</div>
  				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
