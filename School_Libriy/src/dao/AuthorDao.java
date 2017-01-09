package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.BaseDao;
import utils.IParamBinding;
import utils.IRowMapping;
import daomain.Author;

public class AuthorDao extends BaseDao {

	public void save(final Author author) {
//		String sql = "insert into authors values('0','"+author.getFirstName()+"','"+author.getLastName()+"')";
//		super.updateBySql(sql);
		
		String sql = "insert into authors values(?, ?,?)";
		super.updateBySql(sql, new IParamBinding(){
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, 0);
				pstmt.setString(2, author.getFirstName());
				pstmt.setString(3, author.getLastName());
			}
		});
	}

	public void delete(int authorId) {
		String sql = "delete from authors where authorId=" + authorId;
		super.updateBySql(sql);
	}

	public Author getAuthor(int authorID) {
		String sql ="select * from authors where authorID = "+authorID;
		
		 @SuppressWarnings("unchecked")
		List<Author> author =  queryBySql(sql, new AuthorMapping());
		return author.size() == 0 ? null : author.get(0);
	}

	
	public void update(Author author) {
		String sql = String
				.format("update authors set firstName='%s',lastName='%s' where authorID='%d' ",
						author.getFirstName(), author.getLastName(),
						author.getAuthorID());
		super.updateBySql(sql);
	}


	@SuppressWarnings("unchecked")
	public List<Author> getAll() {
		String sql = "select *  from authors";
		return super.queryBySql(sql, new AuthorMapping());
			
	}
	
	@SuppressWarnings("unchecked")
	public List<Author> queryAll(){
//		return super.queryBySql("select * from authors", new IRowMapper() {
//			public Object mappingRow(ResultSet rs) throws SQLException {
//				AuthorModel model = new AuthorModel(rs.getInt("authorId"), rs.getString("firstName"), rs.getString("lastName"));
//				return model;
//			}
//		});
		return queryBySql("select * from authors", new AuthorMapping());
	}
	
	//封装数据的内部类
	class AuthorMapping implements IRowMapping{
		
		public Object MappingRow(ResultSet rs) {
			Author author = null;
			try {
				author = new Author(rs.getInt("authorID"),rs.getString("firstName"),rs.getString("lastName"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return author;
		}
	}
}

