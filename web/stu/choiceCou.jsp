<%@ page language="java" import="java.util.*,com.mao.dao.*,com.mao.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-正在选课</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <script language="javascript">
		  //选中全选按钮，下面的checkbox全部选中
		  var selAll = document.getElementById("selAll");
		  function selectAll() {
			  var obj = document.getElementsByName("checkAll");
			  if (document.getElementById("selAll").checked == false) {
				  for (var i = 0; i < obj.length; i++) {
					  obj[i].checked = false;
				  }
			  } else {
				  for (var i = 0; i < obj.length; i++) {
					  obj[i].checked = true;
				  }
			  }
		  }
		  //当选中所有的时候，全选按钮会勾上
		  function setSelectAll() {
			  var obj = document.getElementsByName("checkAll");
			  var count = obj.length;
			  var selectCount = 0;
			  for (var i = 0; i < count; i++) {
				  if (obj[i].checked == true) {
					  selectCount++;
				  }
			  }
			  if (count == selectCount) {
				  document.all.selAll.checked = true;
			  } else {
				  document.all.selAll.checked = false;
			  }
		  }
		  //反选按钮
		  function notSelectAll() {
			  var checkboxs = document.getElementsByName("checkAll");
			  for (var i = 0; i < checkboxs.length; i++) {
				  var e = checkboxs[i];
				  e.checked = !e.checked;
				  setSelectAll();
			  }
		  }
	  </script>
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
		stu = (Student)session.getAttribute("student");
	}%>
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
			<form action="servlet/serInsertSc" method="post">
			<%Course cou = null;
  				DaoCou selectcou = new DaoCou();
  				Iterator<Course> list = selectcou.selectCou(); 
  			%>
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td>
						<td><input type="checkbox" id="selAll" onclick="selectAll();" />全选
							<input type="checkbox" id="inverse" onclick="notSelectAll();" />反选 </td>
  						
  					</tr>
  					<% 
  						while(list.hasNext()){
  						cou = list.next();
  						%>
  					<tr>
  					<td><%= cou.getCNo() %></td>
  					<td><%= cou.getCname() %></td>
  					<td><%= cou.getCcredit() %></td>
  					<td><input type="checkbox" name="checkAll"id="checkAll" onclick="setSelectAll();" value="<%= cou.getCNo()%>" /> </td>
  					</tr>
		  			<%
  					}
     			%>
     			<tr><td></td></tr><tr><td></td><td></td>
  					<td><input class="sure" type="submit" value="确定"></td>
					<td><input class="cancle" type="reset" value="取消"></td>
  				</table>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
