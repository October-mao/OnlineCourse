package com.mao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mao.utils.DBUtils;
import com.mao.bean.Student;
/**
 * 学生增删查改操作
 * @author 毛浩玮
 */
public class DaoStu {
	/*
	 * 学生登录
	 **/
	public Student loginStu(Student stu){
		Student stu1 = null;
		String sql_loginS="select * from student where SNo=? and Spassword=?;";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_loginS);
			pst.setInt(1, stu.getSNo());
			pst.setString(2,stu.getSpassword());
			rs = pst.executeQuery();
			if(rs.next()){
				stu1 = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),0,rs.getString(6),rs.getString(7));
				System.out.println("student login select over");
				System.out.println(stu1.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn,pst,rs);
		}
		return stu1;
	}
	/*
	 * 查询所有学生
	 * */
	public List<Student> selectStu() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Student> list = null;
		try {
			String sql_select = "select SNo,Sname,Spassword,Sclass,Ssex,PublishTime from student;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_select);
			rs = pst.executeQuery();
			list = new ArrayList<Student>();
			DaoCou scredit = new DaoCou();
			while (rs.next()) {
				Student stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass")
						, rs.getString("Ssex"), scredit.selectScre(rs.getInt("SNo")),rs.getString("PublishTime"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, pst, rs);
		}
		return list;
	}


	/*
	 * 查询学生总学分_某位学生
	 * */
	public Student selectScre(Student stu) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql_insert = "select student.sno as sno,sum(course.ccredit) as scredit from student,sc,course" +
					"	where student.sno=sc.sno" +
					"		and sc.cno=course.cno" +
					"		 and student.sno=?";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_insert);
			pst.setInt(1, stu.getSNo());
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("Student_id" + stu.getSNo() + "select one over!");
				stu = new Student(rs.getInt("sno"), null, null, null, null, rs.getFloat("scredit"),null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, pst, rs);
		}
		return stu;
	}

	/*
	 * 查询某条个学生
	 * */
	public Student selectStu(int id) {
		Student Stu = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql_selectone = "select * from student where SNo=?";//查询某一条课程
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_selectone);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass")
						, rs.getString("Ssex"), 0, rs.getString("publishTime"),rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, pst, rs);
		}
		return Stu;
	}


	/*
	 * 修改某个学生信息
	 * */
	public int updateStu(Student stu) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String sql_update = "update Student set Sname=?,Spassword=?,Sclass=?,Ssex=?,PublishTime=?,Photo=? where SNo=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_update);
			pst.setString(1, stu.getSname());
			pst.setString(2, stu.getSpassword());
			pst.setString(3, stu.getSclass());
			pst.setString(4, stu.getSsex());
			pst.setString(5,stu.getPublishTime());
			pst.setString(6,stu.getPhoto());
			pst.setInt(7, stu.getSNo());
			rs = pst.executeUpdate();
			if (rs != 0) {
				//System.out.println("Student_id" + stu.getSNo() + "update over!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, pst, null);
		}
		return rs;
	}

	/*
	 * 删除某个学生信息
	 * */
	public int deleteStu(int id) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String sql_delete = "delete from student where SNo=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_delete);
			pst.setInt(1, id);
			rs = pst.executeUpdate();
			if (rs != 0) {
				System.out.println("Student_id" + id + "delete over!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, pst, null);
		}
		return rs;
	}

	/*
	 * 添加一位学生信息
	 * */
	public int insertStu(Student stu) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String sql_insert = "insert into student(Sname,Spassword,Sclass,Ssex,PublishTime,Photo) values(?,?,?,?,?,?);";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_insert);
			pst.setString(1, stu.getSname());
			pst.setString(2, stu.getSpassword());
			pst.setString(3, stu.getSclass());
			pst.setString(4, stu.getSsex());
			pst.setString(5,stu.getPublishTime());
			pst.setString(6,stu.getPhoto());
			rs = pst.executeUpdate();
			if (rs != 0) {
				System.out.println("Student_id" + stu.getSNo() + "insert over!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, pst, null);
		}
		return rs;
	}

	public DaoStu() {
	}
}


