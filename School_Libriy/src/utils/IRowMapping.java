package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapping {
	
	/**
	 * ��װ���ݵ��࣬˭���ã�˭ȥʵ��
	 * @param rs
	 * @return
	 */
	public abstract Object MappingRow(ResultSet rs) throws SQLException;


}
