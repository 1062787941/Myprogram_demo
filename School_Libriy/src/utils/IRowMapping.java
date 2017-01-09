package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapping {
	
	/**
	 * 封装数据的类，谁调用，谁去实现
	 * @param rs
	 * @return
	 */
	public abstract Object MappingRow(ResultSet rs) throws SQLException;


}
