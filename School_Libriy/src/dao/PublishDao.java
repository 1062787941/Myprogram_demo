package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.BaseDao;
import utils.IParamBinding;
import utils.IRowMapping;
import daomain.Author;
import daomain.Publish;

public class PublishDao extends BaseDao {

	public void save(final Publish publish) {
//		String sql = "insert into authors values('0','"+author.getFirstName()+"','"+author.getLastName()+"')";
//		super.updateBySql(sql);
		
		String sql = "insert into publishers values(?,?)";
		super.updateBySql(sql, new IParamBinding(){
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, publish.getPublisherID());
				pstmt.setString(2, publish.getPublisherNam());
			}
		});
	}

	public void delete(int publishId) {
		String sql = "delete from publishers where publisherID=" + publishId;
		super.updateBySql(sql);
	}

	public Publish getPublish(int publishId) {
		String sql ="select * from publishers where publisherID = "+publishId;
		
		 @SuppressWarnings("unchecked")
		List<Publish> publish =  queryBySql(sql, new PublishMapping());
		return publish.size() == 0 ? null : publish.get(0);
	}

	
	public void update(Publish publish) {
		String sql = String
				.format("update publishers set publisherName='%s' where publisherID='%d' ",
						publish.getPublisherNam(), publish.getPublisherID());
		super.updateBySql(sql);
	}


	@SuppressWarnings("unchecked")
	public List<Publish> getAll() {
		String sql = "select *  from publishers";
		return super.queryBySql(sql, new PublishMapping());
			
	}
	
	//封装数据的内部类
	class PublishMapping implements IRowMapping{
		
		public Object MappingRow(ResultSet rs) {
			Publish publish = null;
			try {
				publish = new Publish(rs.getInt("publisherID"),rs.getString("publisherName"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return publish;
		}
	}
}

