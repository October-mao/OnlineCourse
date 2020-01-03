package com.mao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mao.utils.DBUtils;
import com.mao.bean.SC;
import com.mao.bean.SedCou;

/**
 * 选课关系操作
 * @author 毛浩玮
 */
public class DaoSc {
	/*
	 * 选课关系插入  	一次插入数条
	 * */
	@SuppressWarnings("null")
	public int[] insertSc(SC sc[]){
		int[] rs = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try{
			String sql = "insert into sc(SNo,CNo,classroom) values(?,?,?);";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			SC tem = null;
			rs = new int[sc.length];
			for(int i = 0;i< sc.length;i++){
				tem = sc[i];
				pst.setInt(1, tem.getSNo());
				pst.setInt(2, tem.getCNo());
				pst.setString(3, tem.getClassroom());
				rs[i] = pst.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,null);
		}
		return rs;
	}

	/*
	 * 选课关系删除  	一次删除一条
	 * */
	public int deleteSc(int sno, int cno) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String sql = "delete from sc where SNo=? and CNo=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			pst.setInt(2, cno);
			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,null);
		}
		return rs;
	}

	/*
	 * 查询某位学生已选课程
	 * */
	public Iterator<SedCou> selectSc(int sno) {
		Iterator<SedCou> listall = null;
		SedCou cou = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			List<SedCou> list = new ArrayList<SedCou>();
			String sql = "select sc.cno,cname,ccredit,classroom from course,sc where course.cno=sc.cno and sno=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			rs = pst.executeQuery();
			while (rs.next()) {
				cou = new SedCou();
				cou.setCNo(rs.getInt("CNo"));
				cou.setCname(rs.getString("Cname"));
				cou.setClassroom(rs.getString("classroom"));
				cou.setCcredit(rs.getFloat("Ccredit"));
				list.add(cou);
				System.out.println("selected course is over!!");
			}
			listall = list.iterator();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn,pst,null);
		}
		return listall;
	}

	/*
	 * 根据学号、课号唯一查询选课关系
	 * */
	public SC selectone(int sno, int cno) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		SC sc = null;
		try {
			String sql = "select * from sc where sno=? and cno=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			pst.setInt(2, cno);
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("classroom select over!!");
				sc = new SC();
				sc.setSNo(rs.getInt("SNo"));
				sc.setCNo(rs.getInt("CNo"));
				sc.setClassroom(rs.getString("Classroom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return sc;
	}

	/*
	 * 选课关系修改教师
	 * */
	public int updateClass(SC sc) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String sql = "update sc set classroom=? where sno=? and cno=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, sc.getClassroom());
			pst.setInt(2, sc.getSNo());
			pst.setInt(3, sc.getCNo());
			rs = pst.executeUpdate();
			if (rs != 0) System.out.println("classroom update over!!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn,pst,null);
		}
		return rs;
	}

}
