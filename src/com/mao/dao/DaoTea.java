package com.mao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mao.utils.DBUtils;
import com.mao.bean.Teacher;

/**
 * 老师登入
 * @author 毛浩玮
 */
public class DaoTea {
	
	/*
	 * 教师登录
	 * */
	public Teacher loginTea(Teacher tea) {
		Teacher tea1 = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql_loginT = "select * from teacher where TNo=? and Tpassword=?;";
			conn = new DBUtils().getConn();
			pst = conn.prepareStatement(sql_loginT);
			pst.setInt(1, tea.getTNo());
			pst.setString(2, tea.getTpassword());
			rs = pst.executeQuery();
			if (rs.next()) {
				tea1 = new Teacher(rs.getInt("TNo"), rs.getString("Tname"), rs.getString("Tpassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn,pst,rs);
		}
		return tea1;
	}

}
