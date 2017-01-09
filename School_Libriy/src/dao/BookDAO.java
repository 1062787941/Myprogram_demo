package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utils.BaseDao;
import utils.IParamBinding;
import utils.IRowMapping;
import daomain.Author;
import daomain.Book;

public class BookDAO extends BaseDao{
	
	/**
	 * 保存图书
	 * @param book
	 */
	public void saveBook(final Book book){
		String sql =  "insert into titles(isbn, title, editionNumber, copyright, publisherId, imageFile, price) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		super.updateBySql(sql, new IParamBinding() {
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, book.getIsbn());
				pstmt.setString(2, book.getTitle());
				pstmt.setInt(3, book.getEditionNumber());
				pstmt.setString(4, book.getCopyright());
				pstmt.setInt(5, book.getPublishId());
				pstmt.setString(6, book.getImageFile());
				pstmt.setDouble(7, book.getPrice());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
		
		String sql2 = "insert into authorIsbn(isbn, authorid) values(?, ?)";
		int []aids = book.getAuthorIds();//作者ID
		if(aids != null){
			for(int i = 0; i < aids.length; i++){
				final int aid = aids[i];
				super.updateBySql(sql2, new IParamBinding() {
					public void bindParam(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, book.getIsbn());
						pstmt.setInt(2, aid);
					}
				});
			}
			
		}
	}
	
	
	public void delete(String isbn){
		String sql = "delete from authorisbn where isbn='"+isbn+"'";
		String sql2 = "delete from titles where isbn='"+isbn+"'";
		updateBySql(sql);
		updateBySql(sql2);
		//super.executeBatch(new String[] { sql, sql2 });
	} 
	
	/**
	 * 更新图书
	 * @param book
	 */
	public void updateBook(final Book book){
		String sql = "update titles set title=?, editionNumber=?, copyright=?, publisherId=?, imageFile=?, price=? " +
				"where isbn=? ";
		super.updateBySql(sql, new IParamBinding() {
			public void bindParam(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, book.getTitle());
				pstmt.setInt(2, book.getEditionNumber());
				pstmt.setString(3, book.getCopyright());
				pstmt.setInt(4, book.getPublishId());
				pstmt.setString(5, book.getImageFile());
				pstmt.setDouble(6, book.getPrice());
				pstmt.setString(7, book.getIsbn());
			}
		});
		
		super.updateBySql("delete from authorisbn where isbn='"+book.getIsbn()+"'");
		
		String sql2 = "insert into authorIsbn(isbn, authorid) values(?, ?)";
		int[] aids = book.getAuthorIds(); // 作者ID列表
		if (aids != null) {
			for (int i = 0; i < aids.length; i++) {
				final int aid = aids[i];
				super.updateBySql(sql, new IParamBinding() {
					public void bindParam(PreparedStatement pstmt)
							throws SQLException {
						pstmt.setString(1, book.getIsbn());
						pstmt.setInt(2, aid);
					}
				});
			}
		}
	}
	
	
	/**
	 * 返回所有的书籍
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Book> queryAll(){
		String sql = "select t.*, publisherName from titles t left outer join publishers p on t.publisherid=p.publisherid ";
		return super.queryBySql(sql, new BookRowMapper());
	} 
	
	/**
	 * 返回一本书
	 * @param isbn
	 * @param title
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Book> quickSearch(String isbn, String title){
		String sql = "select t.*, publisherName from titles t left outer join publishers p on t.publisherid=p.publisherid ";
		sql += " where isbn like '%"+isbn+"%' and title like '%"+title+"%'"; 
		return super.queryBySql(sql, new BookRowMapper());
	}
	
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public Book get(String isbn){
		String sql = "select t.*, publisherName from titles t left outer join publishers p on t.publisherid=p.publisherid where isbn='"+isbn+"'";
		@SuppressWarnings("unchecked")
		List<Book> models = super.queryBySql(sql, new BookRowMapper());
		return models.size() == 0 ? null : models.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Author> getAuthorModelsByIsbn(String isbn){
		String sql = "select authors.* from authors, authorisbn where authors.authorid=authorisbn.authorid and authorisbn.isbn='"
				+ isbn + "'";
		List<Author> myList =  queryBySql(sql, new IRowMapping(){
			@Override
			public Object MappingRow(ResultSet rs) throws SQLException {
				Author model = new Author(rs.getInt("authorid"), rs
						.getString("firstName"), rs.getString("lastName"));
				return model;
			}
		});
		return myList;
	}
	
	@SuppressWarnings("unchecked")
	public Integer[] getAuthorIdsByIsbn(String isbn){
		String sql = "select authorid from authorisbn where isbn='"+isbn+"'";
		List<Integer> myList =  queryBySql(sql, new IRowMapping(){
			@Override
			public Object MappingRow(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
		});
		return (Integer[])myList.toArray(new Integer[0]);
	}
	
	//封装成Book对象
	class BookRowMapper implements IRowMapping {
		public Object MappingRow(ResultSet rs) throws SQLException {
			Book book = new Book();
			book.setCopyright(rs.getString("copyright"));
			book.setEditionNumber(rs.getInt("editionNumber"));
			book.setImageFile(rs.getString("imageFile"));
			book.setIsbn(rs.getString("isbn"));
			book.setPrice(rs.getDouble("price"));
			book.setPublishId(rs.getInt("publisherId"));
			book.setPublishName(rs.getString("publisherName"));
			book.setTitle(rs.getString("title"));
			return book;
		}
	} 
}
