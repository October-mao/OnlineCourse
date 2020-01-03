package com.mao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.mao.utils.DBUtils;
import com.mao.bean.QueryResult;

/**
 * 查询操作
 *
 * @author 毛浩玮
 */
public class DaoQuery {
	/*
	 * 根据学号查询选课情况
	 * */
	public List<QueryResult> selectSno(int sno) {
		List<QueryResult> list = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and student.sno=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			rs = pst.executeQuery();
			while (rs.next()) {
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return list;
	}

	/*
	 * 根据学生姓名查询选课情况
	 * */
	public List<QueryResult> selectSname(String name) {
		List<QueryResult> list = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and student.sname=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return list;
	}

	/*
	 * 根据班级查询选课情况
	 * */
	public List<QueryResult> selectSclass(String _class) {
		List<QueryResult> list = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and student.sclass=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, _class);
			rs = pst.executeQuery();
			while (rs.next()) {
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return list;
	}

	/*
	 * 根据课程号查询选课情况
	 * */
	public List<QueryResult> selectCno(int cno) {
		List<QueryResult> list = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and course.cno=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cno);
			rs = pst.executeQuery();
			while (rs.next()) {
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return list;
	}

	/*
	 * 根据课程名查询选课情况
	 * */
	public List<QueryResult> selectCname(String cname) {
		List<QueryResult> list = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and course.cname=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, cname);
			rs = pst.executeQuery();
			while (rs.next()) {
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return list;
	}

	/*
	 * 根据上课教室查询选课情况
	 * */
	public List<QueryResult> selectRoom(String room) {
		List<QueryResult> list = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and classroom=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, room);
			rs = pst.executeQuery();
			while (rs.next()) {
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return list;
	}

}
