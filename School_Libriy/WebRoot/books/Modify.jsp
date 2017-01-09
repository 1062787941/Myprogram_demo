<%@page import="daomain.Book"%>
<%@page import="dao.BookDAO"%>
<%@page import="daomain.Publish"%>
<%@page import="dao.AuthorDao"%>
<%@page import="daomain.Author"%>
<%@page import="dao.PublishDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	AuthorDao authorDAO = new AuthorDao();
	List<Author> authors = authorDAO.queryAll();	 //得到所有作者
	List<Author> modifyAuthors = new ArrayList<Author>(); //存放当前图书的所有作者对象
	
	PublishDao publisherDAO = new PublishDao();
	List<Publish> publishers = publisherDAO.getAll();
	
	BookDAO bookDao = new BookDAO();
	Book book = bookDao.get(request.getParameter("isbn"));
	//图书的所有作者
	Integer[] titleAuthorIds = bookDao.getAuthorIdsByIsbn(request.getParameter("isbn"));//得到当前图书的所有作者的ID
	
	List<Author> modifyModel = bookDao.getAuthorModelsByIsbn(request.getParameter("isbn"));
	
	if(titleAuthorIds != null && titleAuthorIds.length > 0) { //当前图书有相关作者
		Arrays.sort(titleAuthorIds); //对作者ID进行排序， 数组元素排序
		int id = -1; //查找后的索引值
		for(int i=0; i<authors.size(); i++) { //遍历所有的作者
			Author m = authors.get(i);
			id = Arrays.binarySearch(titleAuthorIds, m.getAuthorID()); //某个作者ID是否在modifyAuthorIds数组内
			if(id >= 0) { //找到元素
				modifyAuthors.add(m);
			}
		}
		authors.removeAll(modifyAuthors); //将图书相关的作者从所有作者列表中删除。
	}
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理-更改图书信息</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">
	<style type="text/css">
		table select{
			width:200px;
		}
		
		.head_color{
			background:  #DDDDFF;
		}
		
		.tcolumn {
				background: #DDDDFF;
		}
		</style>
		<script type="text/javascript">
			//fromSel: 源选择框， toSel:目标选择框
			function moveitem(fromSel, toSel) {
				var fromOpts = fromSel.options; //源选择项列表数组
				var toOpts = toSel.options;  //目标选择项列表数组
				var idx = 0; //当前索引
				var toLen = toOpts.length; // 目标选择框已有的项数
				//遍历所有的源选择项列表数组
				for(var i=fromOpts.length-1; i>=0; i--) {
					if(fromOpts[i].selected){ //如果选中
						toOpts[toLen+idx] = new Option(fromOpts[i].text, fromOpts[i].value);//添加到目标选择框中
						fromOpts[i] = null; //删除源选择框中的选中项
						idx++;
					}
				}
				
			}
			
			//表单提交
			function checkForm(myform) {
				var authorOpts = myform.authorIds.options;
				if(authorOpts != null) {
				
					for(var i=0; i<authorOpts.length; i++) {
						authorOpts[i].selected = true;
					}
				}
				
				if(myform.isbn.value == "") {
					alert('isbn必须输入！');
					myform.isbn.focus();
					return false;
				}
				if(myform.title.value == "") {
					alert('书名必须输入！');
					myform.title.focus();
					return false;
				}
				if(myform.publisherId.value == "") {
					alert('出版社必须选择！');
					myform.publisherId.focus();
					return false;
				}
				var price = parseFloat(myform.price.value);
				if(isNaN(price)){
					alert('价格必须为数字！');
					myform.price.focus();
					return false;
				}
				var copyright = myform.copyright.value;
				if(copyright.length != 4 || isNaN(parseInt(copyright))){
					alert('出版年份必须为4位数字!');
					myform.copyright.focus();
					return false;
				}
				var editionNumber = parseInt(myform.editionNumber.value);
				if(isNaN(editionNumber)) {
					alert('版本号必须为数字！');
					myform.editionNumber.focus();
					return false;
				}
				
				return true;
			}
		</script>
  </head>
  
  <body>
  	<%@include file="/inc/head.jsp" %>
   
	 <br />
	<form name="form1" action="books/update.jsp" method="post" onsubmit="return checkform(this)">
		<table align="center" width="980">
			<caption>更改图书信息</caption>
			<tr>
				<td width="250" class="head_color">图书的ISBN</td>
				<td width="730" style="background: #CCCCCC">
					<%=book.getIsbn() %>
				</td>
			</tr>
			<tr>
				<td class="head_color">书名</td>
				<td>
					<input type="text" size="40" value="<%=book.getTitle() %>">
				</td>
			</tr>
			<tr>
				<td class="head_color">出版社</td>
				<td width="">
					<select name="publisherId">
						<option>请选择....</option>
						<%
							String pubSel = "";
							for(Publish publish : publishers) {
								if(publish.getPublisherID() == book.getPublishId())
									pubSel = " selected ";
								else
									pubSel = "";
						%>
							<option value="<%=publish.getPublisherID() %>" <%=pubSel %>><%=publish.getPublisherNam() %></option>
						<%} %>
					</select>
				<td>
			</tr>
			<tr>
				<td class="head_color">价格</td>
				<td width="">
					<input type="text" name="price" value="<%=book.getPrice() %>">*
				</td>
			</tr>
			<tr>
				<td class="head_color">出版年份</td>
				<td width="">
						<input type="text" name="copyright" value="<%=book.getCopyright() %>">*
				</td>
			</tr>
			<tr>
				<td class="head_color">版本号</td>
				<td width="">
					<input type="text" name="editionNumber" value="<%=book.getEditionNumber() %>">*
				</td>
			</tr>
			<tr>
				<td class="head_color">作者</td>
				<td width="">
				<table>
						<tr>
							<td>
								<select name="allauthors" multiple="multiple" size="8">
									<%
										for(Author model : authors) {
									 %>
									<option value="<%=model.getAuthorID() %>"><%=model.getFirstName() %>&nbsp; <%=model.getLastName() %></option>
									<%
										}
									 %>
								</select>
							</td>
							<td>
								<input type="button" value="增加>>" onclick="javascript:moveitem(form1.allauthors, form1.authorIds);">
								<br>
								<input type="button" value="<<删除" onclick="javascript:moveitem( form1.authorIds, form1.allauthors);">
							</td>
							<td>
								<select name="authorIds" multiple="multiple" size="8">
									<%
										for(Author model : authors) {
									 %>
										<option value="<%=model.getAuthorID() %>"><%=model.getFirstName() %>&nbsp; <%=model.getLastName() %></option>
									<%
										}
									 %>
								</select>
							</td>
						</tr>
					</table>
				<td>
			</tr>
			<tr>
				<td colspan="2" align="center" class="tcolumn">
					<input type="submit" value="修改">
					<input type="reset" value="清空">
					<input type="button" value="返回" onclick="history.go(-1);">
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>