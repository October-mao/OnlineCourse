<%@ page language="java" import="java.util.*,com.mao.bean.Student" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统</title>
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
  <% 	Student stu = null;
  		if(session.getAttribute("student")==null){
  			response.sendRedirect("../Login.jsp");
  		}else{
  			stu = (Student)session.getAttribute("student");}
  %>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
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
			<table class="news">
			<tr><td><b>关于本学期校级任选课相关事宜安排的通知</b></td></tr>
			<tr><td>各学院及相关单位:</td></tr>
			<tr><td>根据学校教学安排，下学期全校任选课定于3月9日（星期一） 正式开课，选课工作将从12月10日开始。现将有关事项通知如下：</td></tr>
			<tr><td>一、选课时间：1月22日----2月6日</td></tr>
			<tr><td>二、学生登录选课信息管理系统后进入学生选课进行选课。学生选课前请认真阅读选课公告，再进行“网上选课”。</td></tr>
			<tr><td>三、教师可登陆选课信息管理系统后进入选课管理增删课程， 6月21日14:00之后各位教师及学生登录教务处网站查询自己申报的课程是否停开。</td> </tr>
			<tr><td>四、选课退课均须在选课时间内完成，选课结束后不再进行补退选，请学生注意选课时间。</td></tr>
			<tr><td>五、请各学院通知并组织学生进行选课，同时请各学院及相关单位通知任课教师按时上课。教务处将组织相关人员对上课情况进行不定期的检查。</td></tr>
			<tr><td align="right">2019-12-10</td></tr>
			</table>
			</div>
		</div>
	</div>
</div>
</body>

</html>
