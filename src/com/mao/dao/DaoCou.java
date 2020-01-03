package com.mao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mao.utils.DBUtils;
import com.mao.bean.Course;

/**
 * 对课程的所有数据库操作
 *
 * @author 毛浩玮
 */
public class DaoCou {

    public static final String sql_select = "select * from course;";
    public static final String sql_selectone = "select * from course where CNo=?";
    public static final String sql_update = "update course set Cname=?,Ccredit=? where CNo=?;";
    public static final String sql_delete = "delete from course where Cno=?;";
    public static final String sql_insert = "insert into course(Cname,Ccredit) values(?,?);";


    /*
     * 查询所有课程信息
     * */
    public Iterator<Course> selectCou() {
        List<Course> list = null;
        Iterator<Course> listall = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConn();
            pst = conn.prepareStatement(sql_select);
            rs = pst.executeQuery();
            list = new ArrayList<Course>();
            while (rs.next()) {
                Course cou = new Course(rs.getInt("CNo"), rs.getString("Cname"), rs.getString("Ccredit"));
                list.add(cou);
            }
            listall = list.iterator();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pst, rs);   //关闭释放
        }
        return listall;
    }

    /*
     * 查询某条课程信息
     * */
    public Course selectCou(int id) {
        Course cou = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConn();
            pst = conn.prepareStatement(sql_selectone);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                cou = new Course(rs.getInt("CNo"), rs.getString("Cname"), rs.getString("Ccredit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pst, rs);   //关闭释放
        }
        return cou;
    }

    /*
     * 修改某条课程信息
     * */
    public int updateCou(Course cou) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = new DBUtils().getConn();
            pst = conn.prepareStatement(sql_update);
            pst.setString(1, cou.getCname());
            pst.setString(2, cou.getCcredit());
            pst.setInt(3, cou.getCNo());
            rs = pst.executeUpdate();
            if (rs != 0) {
                System.out.println("course_id" + cou.getCNo() + "update over!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pst, null);
        }
        return rs;
    }

    /*
     * 删除某条课程信息
     * */
    public int deleteCou(int id) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = new DBUtils().getConn();
            pst = conn.prepareStatement(sql_delete);
            pst.setInt(1, id);
            rs = pst.executeUpdate();
            if (rs != 0) {
                System.out.println("course_id" + id + "delete over!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pst, null);
        }
        return rs;
    }

    /*
     * 添加一条课程信息
     * */
    public int insertCou(Course cou) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = new DBUtils().getConn();
            pst = conn.prepareStatement(sql_insert);
            pst.setString(1, cou.getCname());
            pst.setString(2, cou.getCcredit());
            rs = pst.executeUpdate();
            if (rs != 0) {
                System.out.println("course_id" + cou.getCname() + "insert over!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pst, null);
        }
        return rs;
    }

    /*
     * 根据学号，查询学生总学分
     * */
    public float selectScre(int sno) {
        float sum = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select sc.sno,sum(ccredit) as scredit from sc,course where sc.cno=course.cno and sno=?;";
            conn = new DBUtils().getConn();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            rs = pst.executeQuery();
            if (rs.next()) {
                sum = rs.getFloat("scredit");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pst, rs);
        }
        return sum;
    }
}
