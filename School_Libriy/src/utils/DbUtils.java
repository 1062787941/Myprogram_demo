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
		// ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("�������سɹ�����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		logger.debug("��ȡ���ݿ����ӣ���");
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * �ر�Statement
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
	 * �ر�����Connection
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
	 * �رս����ResultSet
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
	 * �ر�����
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
	 * ������ύ
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
	 * ����Ļع�
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
