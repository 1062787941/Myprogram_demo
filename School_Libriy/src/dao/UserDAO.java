package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utils.BaseDao;
import utils.IParamBinding;
import utils.IRowMapping;
import utils.PageUtil;
import daomain.User;

public class UserDAO extends BaseDao {
	
	public void saveUser(final User user){
		String sql = "insert into bookusers(account, password, name, createTime) values(?, ?, ?, now())";
		super.updateBySql(sql, new IParamBinding() {
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getAccount());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
			}
		});
	}
	
	public void updateUser(final User model){
		String sql = "update bookusers set account=?, password=?, name=? where userId=?";
		super.updateBySql(sql, new IParamBinding() {
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, model.getAccount());
				pstmt.setString(2, model.getPassword());
				pstmt.setString(3, model.getName());
				pstmt.setInt(4, model.getUserId());
			}
		});
	}
	
	public void deleteUser(int id){
		String sql = "delete from bookusers where userid="+id;
		updateBySql(sql);
	}
	
	public User getUser(int id){
		@SuppressWarnings("unchecked")
		List<User> users = queryBySql("select * from bookusers where userid="+id, new UserRowMapper() ); 
		if(users == null || users.size() == 0)
			return null;
		else
			return users.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> queryAll(){
		return queryBySql("select * from bookusers", new UserRowMapper() );
	}
	
	@SuppressWarnings("unchecked")
	public User login(final String account, final String password){
		String sql = "select * from bookusers where account=? and password=?";
		System.out.println(sql);
		List<User> models = queryBySql(sql, new IParamBinding(){
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, account);
				pstmt.setString(2, password);
			}
		}, new UserRowMapper());
		
		if(models == null || models.size() == 0)
			return null;
		else
			return models.get(0);
	}


	
	class UserRowMapper implements IRowMapping {
		public Object MappingRow(ResultSet rs) throws SQLException {
			User model = new User();
			model.setAccount(rs.getString("account"));
			model.setName(rs.getString("name"));
			model.setPassword(rs.getString("password"));
			model.setUserId(rs.getInt("userId"));
			String createTime = PageUtil.parseDateTime(rs.getTimestamp("createTime"), "yyyy-MM-dd HH:mm:ss");
			model.setCreateTime(createTime);
			return model;
		}
	}
}
