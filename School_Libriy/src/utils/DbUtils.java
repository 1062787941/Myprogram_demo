package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class DbUtils {
	
	private static String url = "jdbc:mysql://localhost:3306/books";
	private static String user = "root";
	private static String password = "root";
	
	private static Logger logger = Logger.getLogger(DbUtils.class);
	
	static {
		// 注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("驱动加载成功！！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取链接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		logger.debug("获取数据库连接！！");
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * 关闭Statement
	 * @param statement
	 */
	public static void closeStatement(Statement statement){
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接Connection
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭结果集ResultSet
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs){
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭所有
	 * @param rs
	 * @param statement
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement statement, Connection conn){
		closeResultSet(rs);
		closeStatement(statement);
		closeConnection(conn);
	}
	
	/**
	 * 事务的提交
	 * @param conn
	 */
	public static void commitTrans(Connection conn){
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 事务的回滚
	 * @param conn
	 */
	public static void robackTrans(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
