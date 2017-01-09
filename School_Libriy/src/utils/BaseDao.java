package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class BaseDao {
	
	static Logger  logger = Logger.getLogger(BaseDao.class);//Class
	
	/**
	 * ִ���� ɾ �� �����������ؽ����
	 * @param sql
	 * @return
	 */
	public int updateBySql(String sql){
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn = DbUtils.getConnection();
			statement = conn.createStatement();
			logger.debug(sql);
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			DbUtils.closeStatement(statement);
			DbUtils.closeConnection(conn);
		}
	}
	
	public int updateBySql(String sql,IParamBinding bind){
		Connection conn = null;
		PreparedStatement prstm  = null;
		
		try {
			conn = DbUtils.getConnection();
			prstm = conn.prepareStatement(sql);
			logger.debug(sql);
			bind.bindParam(prstm); //������
			return prstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			DbUtils.closeStatement(prstm);
			DbUtils.closeConnection(conn);
		}
	}
	

	/**
	 * ��ѯ
	 */
	public List queryBySql(String sql, IRowMapping mapper){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List retList = new ArrayList();
		try {
			conn = DbUtils.getConnection();
			stmt = conn.createStatement();
			logger.debug(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Object obj = mapper.MappingRow(rs);
				//AuthorModel model = new AuthorModel(rs.getInt("authorId"), rs.getString("firstName"), rs.getString("lastName"));
				retList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeAll(rs, stmt, conn);
		}
		return retList;
	}
	
	@SuppressWarnings("rawtypes")
	public List queryBySql(String sql, IParamBinding bind, IRowMapping mapper){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List retList = new ArrayList();
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			logger.debug(sql);
			bind.bindParam(pstmt); //������
			rs = pstmt.executeQuery();
			while(rs.next()){
				Object obj = mapper.MappingRow(rs);
				//AuthorModel model = new AuthorModel(rs.getInt("authorId"), rs.getString("firstName"), rs.getString("lastName"));
				retList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeAll(rs, pstmt, conn);
		}
		return retList;
	}
	
	/**
	 * ִ�ж�������������SQL���
	 * @param sqls
	 * @return
	 */
	public int[] executeBatch(String[] sqls){
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn = DbUtils.getConnection();
			conn.setAutoCommit(false);//��������
			statement = conn.createStatement();
			
			for(int i=0;i<sqls.length;i++){
				statement.addBatch(sqls[i]);
			}
			return statement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �����𴴽��͹ر�Connection�� ��IConnectionCreator���������ݲ�����
	 * @param onnectionCreator
	 * @return
	 */
	public boolean executeInConnection(IConnectionCreator connCreator){
		Connection conn =null;

		try {
			conn = DbUtils.getConnection();
			conn.setAutoCommit(false);//��������
			boolean  success = connCreator.doInConnection(conn);
			if( !success)
				DbUtils.robackTrans(conn);
			else
				DbUtils.commitTrans(conn);
			return true;
			
		} catch (SQLException e) {
			DbUtils.robackTrans(conn);
			logger.debug("ִ��SQL�쳣");
			e.printStackTrace();
		}finally{
			DbUtils.closeConnection(conn);
		}
		return false;
	}
	
	
	
	
}
