<%@ page language="java" import="java.util.*,com.mao.bean.*,com.mao.dao.*" pageEncoding="utf-8"%>
<%@ page import="com.mao.utils.DBUtils" %>
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-课程信息</title>
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
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src= img/touxiang.png></div>
			<div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class03"><a href="tea/Query.jsp">信息查询</a></div>
			<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('servlet/serDoLogout')">
		</div>
	</div>
					<%
	  	Teacher tea = null;
	  	if(session.getAttribute("teacher")==null){
	  		response.sendRedirect("Login.jsp");
	  	}else{
	  		tea = (Teacher)session.getAttribute("teacher");
	   %>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= tea.getTname() %>老师，您好！！！</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>

			<div class="form">
				<table border="0">
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>修改课程</td><td>删除课程</td>
  						<td><input class="btn" type="button" value="添加课程" onclick="window.location.href=('tea/InsertCou.jsp')"/></td>
  						
  					</tr>
			  		<%
						String sql_select = "select * from course";
						Connection conn = new DBUtils().getConn();
						Statement pst = null;
						try {
							pst = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_UPDATABLE);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						ResultSet rs = pst.executeQuery(sql_select);
						int intPageSize;//一页显示的记录数
						int intRowCount;//记录总数
						int intPageCount;//总页
						int intPage;//待显示页码
						String strPage;
						int i;
						intPageSize = 9;//设置一页显示的记录数
						strPage = request.getParameter("page");//取得待显示页码
						if (strPage == null) {//表明在ＱueryString中没有page这个参数，则显示第一页数据
							intPage = 1;
						} else {//将字符串换成整型
							intPage = Integer.parseInt(strPage);
							if (intPage < 1)
								intPage = 1;
						}
						rs.last();//记录指针指向查询结果集中最后一条记录
						intRowCount = rs.getRow();//获取记录总数
						intPageCount = (intRowCount + intPageSize - 1) / intPageSize;//记录总页数
						if (intPage > intPageCount)
							intPage = intPageCount;//调整待显示的页码
						if (intPageCount > 0) {
							rs.absolute((intPage - 1) * intPageSize + 1);//将记录指针定位到待显示页的第一条记录上．
							//显示数据
							i = 0;
							while(i<intPageSize&&!rs.isAfterLast()){
								int cno = rs.getInt("CNo");
								String cname = rs.getString("Cname");
								String ccredit = rs.getString("Ccredit");
			   		%>
  					<tr>
  					<td><%=cno %></td>
  					<td><%=cname %></td>
  					<td><%=ccredit %></td>
  					<td><input  class="btn" type="button" value="修改课程" onClick="window.location.href=('tea/updateCou.jsp?id=<%=cno %>')"></td>
  					<td><input  class="btn" type="button" value="删除课程" onClick="window.location.href=('servlet/serDeleteCou?id=<%=cno %>')"></td>
  					</tr>
		  				<%
									try {
										rs.next();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									i++;
		   			}
		   		}
		    %><tr>
					<td colspan=11>
							第<%=intPage%>页 共<%=intPageCount%>页
							<%
								if (intPage < intPageCount) {
							%>
							<a href="tea/selectCou.jsp?page=<%=intPage+1%>" style="color:blue">下一页</a>
							<%
								}
								if (intPage > 1) {
							%>
							<a href="tea/selectCou.jsp?page=<%=intPage-1%>" style="color:blue">上一页</a>
							<%
									}
								}
	  						%>
					</td>
				</tr></table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
