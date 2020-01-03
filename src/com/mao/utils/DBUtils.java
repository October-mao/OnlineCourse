package com.mao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class DBUtils {
	Connection conn = null;
	public Connection getConn() throws IOException {
        //把配置文件的值取出来Class
        Properties pop = new Properties(); //创建Properties类的对象，获取jdbc.properties文件
        //取到配置文件jdbc.properties的内容
        InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        pop.load(in);//把拿到的配置文件的内容，放到Properties类的对象pop
        String driverClass = pop.getProperty("driverClass");  //通过pop对象getProperties方法，拿到配置文件的键值对
        String urlClass = pop.getProperty("url");
        String user = pop.getProperty("user");
        String password = pop.getProperty("password");
		try{
			Class.forName(driverClass);
			conn = DriverManager.getConnection(urlClass,user,password);
		}catch(Exception e){e.printStackTrace();}
		return conn;
	}

	/**
	 * 通用关闭数据库有关连接的资源操作
	 * 资源释放
	 */
	public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pst != null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
